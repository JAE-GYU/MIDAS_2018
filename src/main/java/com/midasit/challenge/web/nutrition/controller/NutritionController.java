package com.midasit.challenge.web.nutrition.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midasit.challenge.web.nutrition.dao.NutritionDao;
import com.midasit.challenge.web.nutrition.model.Nutrition;
import com.midasit.challenge.web.util.cmd.CMD;
import com.midasit.challenge.web.util.format.ResponseFormat;

@RestController
@RequestMapping("/nutrition")
public class NutritionController {
	@Autowired
	private NutritionDao nutritionDao;
	
	@PersistenceContext
	private EntityManager em;
	
	@GetMapping
	public ResponseFormat<List<Nutrition>> list(){
		List<Nutrition> nutritionList = nutritionDao.findAll();
		ResponseFormat<List<Nutrition>> format = new ResponseFormat<List<Nutrition>>(nutritionList);
		if(nutritionList == null){
			format.setDescription(CMD.description(CMD.LIST));
	    }
		return format;
	}
	
	/**
	 * /nutrition/0
	 */
	@GetMapping("/{id}")
	public ResponseFormat<Nutrition> view(@PathVariable int id) {
		Nutrition nutrition = nutritionDao.getOne(id);
		ResponseFormat<Nutrition> format = new ResponseFormat<Nutrition>(nutrition);
		if(nutrition != null) {
			format.setDescription(CMD.description(CMD.VIEW));
		}
		return new ResponseFormat<Nutrition>(nutrition);
	}

	@PostMapping
	public ResponseFormat<Nutrition> add(@RequestBody Nutrition nutrition) {
		ResponseFormat<Nutrition> format = new ResponseFormat<Nutrition>();
		if(nutrition == null) {
			format.setDescription(CMD.description(CMD.INSERT));
		}
		nutritionDao.save(nutrition);
		return format;
	}
	
	@DeleteMapping({"/{id}"})
	public ResponseFormat<Nutrition> delete(@PathVariable int id) {
		nutritionDao.deleteById(id);
		ResponseFormat format = new ResponseFormat();
		return format;
	}
}
