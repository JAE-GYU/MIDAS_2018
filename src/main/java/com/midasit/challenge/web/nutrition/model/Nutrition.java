package com.midasit.challenge.web.nutrition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Nutrition")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Nutrition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nutrition_id", updatable = false, nullable = false)
	private int nutrition_id;
	
	@Column(name = "menu_id", updatable = false, nullable = false)
	private int menu_id;
	
	@Column(name = "reference", updatable = false, nullable = false)
	private String reference;
	
	@Column(name = "kcal", updatable = false, nullable = false)
	private int kcal;
	
	@Column(name = "saturated_fat", updatable = false, nullable = false)
	private int saturated_fat;
	
	@Column(name = "protein", updatable = false, nullable = false)
	private int protein;
	
	@Column(name = "salt", updatable = false, nullable = false)
	private int salt;
	
	@Column(name = "sugars", updatable = false, nullable = false)
	private int sugars;
	
	@Column(name = "caffeine", updatable = false, nullable = false)
	private int caffeine;
}
