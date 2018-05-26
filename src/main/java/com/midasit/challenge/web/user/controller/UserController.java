package com.midasit.challenge.web.user.controller;

import com.midasit.challenge.web.user.service.UserService;
import com.midasit.challenge.web.util.cmd.CMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import com.midasit.challenge.web.user.model.User;
import com.midasit.challenge.web.user.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PersistenceContext
    private EntityManager em;

    @GetMapping
    private ResponseFormat list(){
        List<User> listUser = userService.findAllUser();
        ResponseFormat responseFormat = new ResponseFormat(listUser);
        if(listUser == null){
            responseFormat.setDescription(CMD.description(CMD.LIST));
        }
        return responseFormat;
    }

    @GetMapping("/{id}")
    private ResponseFormat view(@PathVariable int id){
        User user = em.find(User.class, id);
        ResponseFormat responseFormat = new ResponseFormat(user);
        if(user == null){
            responseFormat.setDescription(CMD.description(CMD.VIEW));
        }
        return responseFormat;
    }

    @PostMapping
    private ResponseFormat add(@RequestBody User user){
        User userList = userService.save(user);
        ResponseFormat responseFormat = new ResponseFormat(userList);
        return responseFormat;
    }

    @PutMapping
    private ResponseFormat update(@RequestBody User user){
        User oriUser = em.find(User.class, user.getUser_id());
        oriUser.update(user);
        userService.save(oriUser);
        ResponseFormat responseFormat = new ResponseFormat(oriUser);
        return responseFormat;
    }

    @DeleteMapping("/{id}")
    private ResponseFormat delete(@PathVariable int id){
        userService.deleteById(id);
        ResponseFormat responseFormat = new ResponseFormat();
        return responseFormat;
    }


}