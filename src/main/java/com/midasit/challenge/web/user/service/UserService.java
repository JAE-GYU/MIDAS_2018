package com.midasit.challenge.web.user.service;

import com.midasit.challenge.web.user.dao.UserRepository;
import com.midasit.challenge.web.user.model.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class UserService<T> {



    @Autowired
    public UserRepository userRepository;

    /**
     * 모든 게시판 목록을 가져온다.
     * @return
     */
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public User getOne(int id) {
        return userRepository.getOne(id);
    }

    /**
     * 게시글을 삭제한다.
     * @param id
     * @return
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    /**
     * 게시글을 저장한다.
     * @param user
     * @return
     */
    public User save(User user) {
        return userRepository.save(user);
    }
}

