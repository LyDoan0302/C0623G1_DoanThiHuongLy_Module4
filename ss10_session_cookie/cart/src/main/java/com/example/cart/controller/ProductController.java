package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();}
    @Autowired
    private IProductService productService;

//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView showProductList(@PageableDefault(value = 5, sort = "price",
//            direction = Sort.Direction.ASC)Pageable pageable) {
//        return new ModelAndView("index", "products", productService.findAll(pageable));
//    }
    @GetMapping
    public ModelAndView showListPage(@PageableDefault(value = 5, sort = "price",
            direction = Sort.Direction.ASC)Pageable pageable,
            Model model, @CookieValue(value = "id", defaultValue = "-1")Long id){
        if(id != -1) {
            model.addAttribute("historyProduct", productService.findByIdOption(id).get());
        }
        return new ModelAndView("index","products",productService.findAll(pageable));
    }
    @GetMapping("/{id}/detail")
    public ModelAndView showDetail(@PathVariable Long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("id", id + "");
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ModelAndView("detail", "product", productService.findByIdOption(id).get());
    }
    @GetMapping("/{id}/add")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart")CartDto cart) {
        Optional<Product> productOptional = productService.findByIdOption(id);
        if(productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);

            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
