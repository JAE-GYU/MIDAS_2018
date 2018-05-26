package com.midasit.challenge.web.nutrition.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midasit.challenge.web.nutrition.model.Nutrition;

public interface NutritionDao extends JpaRepository<Nutrition, Integer>{

}
