package com.midasit.challenge.web.user.dao;

import com.midasit.challenge.web.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{

}
