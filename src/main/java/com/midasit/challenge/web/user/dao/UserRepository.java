package com.midasit.challenge.web.user.dao;

import com.midasit.challenge.web.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select t from User t where email=:email and password=:password")
    List<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
