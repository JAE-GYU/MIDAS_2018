package com.midasit.challenge.web.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midasit.challenge.web.menu.mapper.MenuMapper;
import com.midasit.challenge.web.menu.model.Menu;

@Service
public class MenuService {
	@Autowired
	MenuMapper menuMapper;
	
	public void updateMenu(Menu menu) throws Exception {
		menuMapper.updateMenu(menu);
	}
	
	public List<Menu> getMenuByCategory(String category) throws Exception {
		return menuMapper.getMenuByCategory(category);
	}
}