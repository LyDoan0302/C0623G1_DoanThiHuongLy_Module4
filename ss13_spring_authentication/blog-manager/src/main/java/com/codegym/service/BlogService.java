package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.reposiotry.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

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
    public void delete(Long id) {
//        iBlogRepository.delete(findByid(id));
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> searchBlogByCategoryId(int keyword) {
        return iBlogRepository.searchBlogByCategoryId(keyword);
    }

    @Override
    public List<Blog> searchBlogsByTitleContaining(String title) {
        return iBlogRepository.searchBlogsByTitleContaining(title);
    }
}
