package com.springsecurity.demo.repository;


import com.springsecurity.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    //findBy규칙 -> Username 문법
    public Optional<User> findByUsername(String username);
}
