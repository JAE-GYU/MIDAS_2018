package com.midasit.challenge.web.user.controller;

import com.midasit.challenge.web.user.model.User;
import com.midasit.challenge.web.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/add")
    public User add(User user){
        System.out.println("");
        User userList = userDao.save(user);

        return userList;
    }

    @RequestMapping("/list")
    public List<User> list(Model model){
        List<User> userList = userDao.findAll();

        return userList;
    }


}
