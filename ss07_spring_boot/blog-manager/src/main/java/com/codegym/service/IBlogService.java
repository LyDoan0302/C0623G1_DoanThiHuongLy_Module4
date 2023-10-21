package com.codegym.service;

import com.codegym.model.Blog;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findByid(Long id);
    void save(Blog blog);
    void update(Blog blog);
    void delete(Long id);
}
