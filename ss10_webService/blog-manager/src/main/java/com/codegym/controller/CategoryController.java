package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showCategoryIndexPage(@PageableDefault(value = 2,direction = Sort.Direction.ASC)Pageable pageable) {
        return new ModelAndView("categoryIndex", "categoryList", categoryService.findAll(pageable) );
    }
    @GetMapping("/create")
    public ModelAndView showCreateCategoryPage() {
        return new ModelAndView("/categoryCreate", "category", new Category());
    }
    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable int id) {
        categoryService.delete(id);
        return "redirect:/category";
    }
    @GetMapping("/{id}/view")
    public ModelAndView showCategoryById(@PathVariable int id) {
        return new ModelAndView("categoryView","category", categoryService.findByid(id));
    }
    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/{id}/search")
    public String searchBlogByCategoryId(@PathVariable int id, Model model){
        List<Blog> blogList = blogService.searchBlogByCategoryId(id);
        model.addAttribute("blogList", blogList);
        model.addAttribute("category",categoryService.findByid(id));
        return "viewBlogByCategory";
    }

}
