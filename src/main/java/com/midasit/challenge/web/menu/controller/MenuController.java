package com.midasit.challenge.web.menu.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.midasit.challenge.web.menu.mapper.MenuMapper;
import com.midasit.challenge.web.menu.dao.MenuDao;
import com.midasit.challenge.web.menu.model.Menu;
import com.midasit.challenge.web.menu.service.MenuService;
import com.midasit.challenge.web.util.cmd.CMD;
import com.midasit.challenge.web.util.format.ResponseFormat;

@RestController
@RequestMapping("/menu")
public class MenuController{
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private MenuService menuService;
	
	@PersistenceContext
	private EntityManager em;
	
	@GetMapping
	public ResponseFormat<List<Menu>> list(){
		List<Menu> menuList = menuDao.findAll();
		
		ResponseFormat<List<Menu>> format = new ResponseFormat<List<Menu>>(menuList);
		if(menuList == null){
			format.setDescription(CMD.description(CMD.LIST));
	    }
		return format;
	}
	
	/**
	 * /menu/0
	 */
	@GetMapping("/{id}")
	public ResponseFormat<Menu> view(@PathVariable int id) {
		Menu menu = menuDao.getOne(id);
		ResponseFormat<Menu> format = new ResponseFormat<Menu>(menu);
		if(menu != null) {
			format.setDescription(CMD.description(CMD.VIEW));
		}
		return new ResponseFormat<Menu>(menu);
	}

	@GetMapping("/list/{category}")
	public ResponseFormat<List<Menu>> viewByCategory(@PathVariable String category) throws Exception {
		List<Menu> menu = menuService.getMenuByCategory(category);
		ResponseFormat<List<Menu>> format = new ResponseFormat<List<Menu>>(menu);
		return format;
	}
	
	@PostMapping
	public ResponseFormat<Menu> add(@RequestBody Menu menu) {
		ResponseFormat<Menu> format = new ResponseFormat<Menu>();
		if(menu == null) {
			format.setDescription(CMD.description(CMD.INSERT));
		}
		menu.setDate((new Timestamp(new Date().getTime())));
		menuDao.save(menu);
		return format;
	}
	
	@DeleteMapping({"/{id}"})
	public ResponseFormat<Menu> delete(@PathVariable int id) {
		menuDao.deleteById(id);
		ResponseFormat format = new ResponseFormat();
		return format;
	}
	
	@PutMapping
    private ResponseFormat update(@RequestBody Menu menu) throws Exception {
        Menu originalMenu = em.find(Menu.class, menu.getMenu_id());
        menu.setDate(originalMenu.getDate());
		System.out.println(menu.toString());
		menuService.updateMenu(menu);
		
        ResponseFormat<Menu> responseFormat = new ResponseFormat<Menu>(menu);
        return responseFormat;
    }
}