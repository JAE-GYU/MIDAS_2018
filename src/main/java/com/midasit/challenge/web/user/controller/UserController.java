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
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private HttpSession session = null;

    @PersistenceContext
    private EntityManager em;

    @GetMapping
    private ResponseFormat list(){
        List<User> listUser = userService.findAllUser();
        ResponseFormat responseFormat = new ResponseFormat();
        User user = (User)session.getAttribute("user");
        if(user != null){
            if(user.getGrade().equals("USER")){
                responseFormat.setCode(-1);
                responseFormat.setDescription(CMD.description(CMD.LIST));
                return responseFormat;
            }
        }
        responseFormat.setList(listUser);
        return responseFormat;
    }

    @PostMapping("/login")
    private ResponseFormat login(HttpSession session, @RequestBody User user){
        ResponseFormat responseFormat = new ResponseFormat();
        List<User> listUser = userService.macth(user.getEmail(), user.getPassword());
        responseFormat.setList(listUser);
        if(listUser.size() == 1) {
            saveSession(session, listUser.get(0));
            this.session = session;
        }
        return responseFormat;
    }

    @PostMapping("/logout")
    private ResponseFormat logout(HttpSession session){
        ResponseFormat responseFormat = new ResponseFormat();
        if(session.getAttribute("user") != null){
            removeSession(session);
        }
        return responseFormat;
    }

    private void saveSession(HttpSession session, User user){
        if (session.getAttribute("user") == null) {
            session.setAttribute("user", user);
        }
    }

    private void removeSession(HttpSession session){
        if (session.getAttribute("user") == null) {
            session.removeAttribute("user");
        }
    }

    private Boolean isSession(HttpSession session){
        return session.getAttribute("user") != null;
    }


//    @GetMapping("/test1")

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
        User oriUser = em.find(User.class, id);
        ResponseFormat responseFormat = new ResponseFormat();

        if(oriUser != null) {
            responseFormat.setCode(100);
            userService.deleteById(id);
            responseFormat.setDescription("success");
        }else{
            responseFormat.setCode(-1);
            responseFormat.setDescription(CMD.description(CMD.DELETE));
        }
        return responseFormat;
    }

}
