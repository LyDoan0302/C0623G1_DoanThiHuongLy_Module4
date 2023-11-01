package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String showBlogList(@PageableDefault(value = 2,
            sort="createDate", direction = Sort.Direction.DESC) Pageable pageable,Model model) {
        LocalDate createDate = LocalDate.now();
        Page<Blog> blogList = blogService.findAll(pageable);
        model.addAttribute("createDate", createDate);
        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryService.findAll());
        return "index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(Model model) {
        model.addAttribute("categoryList",categoryService.findAll());
        return new ModelAndView("create","blog",new Blog());

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
    public ModelAndView showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return new ModelAndView("edit", "blog", blogService.findByid(id));
    }
    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/search")
    public ModelAndView searchBlogByTitle(@RequestParam String title) {
        return new ModelAndView("search", "blogList", blogService.searchBlogsByTitleContaining(title));
    }



}
