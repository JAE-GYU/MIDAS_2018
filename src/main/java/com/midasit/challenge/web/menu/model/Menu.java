package com.midasit.challenge.web.menu.model;

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
@Table(name = "MENU")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id", updatable = false, nullable = false)
	private int menu_id;
	
	@Column(name = "menu_ko", updatable = false, nullable = false)
	private String menu_ko;
	
	@Column(name = "menu_en", updatable = false, nullable = false)
	private String menu_en;
	
	@Column(name = "price", updatable = false, nullable = false)
	private int price;
	
	@Column(name = "date", updatable = false, nullable = false)
	private Date date;
	
	@Column(name = "category", updatable = false, nullable = false)
	private String category;
	
	@Column(name = "img_link", updatable = false, nullable = false)
	private String img_link;
	
	public void update(Menu menu) {
		this.menu_ko = menu.getMenu_ko();
		this.menu_en = menu.getMenu_en();
		this.price = menu.getPrice();
		this.category = menu.getCategory();
		this.img_link = menu.getImg_link();
	}
}
