package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.reposiotry.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findByid(Long id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
//        iBlogRepository.delete(findByid(id));
        iBlogRepository.deleteById(id);
    }
}
