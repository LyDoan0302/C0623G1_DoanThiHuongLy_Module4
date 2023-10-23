package com.codegym.service;

import com.codegym.model.Blog;
import org.apache.catalina.LifecycleState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAll();
    Blog findByid(Long id);
    void save(Blog blog);
    void delete(Long id);
    List<Blog> searchBlogByCategoryId(int keyword);
    List<Blog> searchBlogsByTitleContaining(String title);
}
