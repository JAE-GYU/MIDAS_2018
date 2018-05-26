package com.midasit.challenge.web.menu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midasit.challenge.web.menu.model.Menu;

public interface MenuDao extends JpaRepository<Menu, Integer> {
	
}
