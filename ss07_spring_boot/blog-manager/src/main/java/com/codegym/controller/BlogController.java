package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ModelAndView showBlogList() {
        return new ModelAndView("index", "blogList", blogService.findAll());
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "blog", new Blog());
    }
    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/view")
    public ModelAndView viewBlogByDetail(@PathVariable Long id) {
        return new ModelAndView("view", "blog", blogService.findByid(id));
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id) {
        return new ModelAndView("edit", "blog", blogService.findByid(id));
    }
    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute Blog blog) {
        blogService.update(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/";
    }

}
