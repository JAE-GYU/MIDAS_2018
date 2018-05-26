package com.midasit.challenge.web.menu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.midasit.challenge.web.menu.model.Menu;

@Mapper
public interface MenuMapper {
	public void updateMenu(Menu menu) throws Exception;
	
	public List<Menu> getMenuByCategory(String category) throws Exception;
}
