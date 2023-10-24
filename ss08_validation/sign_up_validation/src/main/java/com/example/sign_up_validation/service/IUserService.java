package com.example.sign_up_validation.service;

import com.example.sign_up_validation.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void remove(Long id);
}
