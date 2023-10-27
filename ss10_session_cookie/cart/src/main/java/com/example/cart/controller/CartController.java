package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false)CartDto cart){
        return new ModelAndView("cartList", "cart", cart);
    }
    @GetMapping("/{id}/plus")
    public String plusProduct(@PathVariable Long id,
                                    @SessionAttribute(value = "cart", required = false)CartDto cart) {
        cart.plusProduct(id);
        return "redirect:/cart";
    }
    @GetMapping("/{id}/subtract")
    public String subtractProduct(@PathVariable Long id,
                                  @SessionAttribute(value = "cart", required = false)CartDto cart){
        cart.subtractProduct(id);
        return "redirect:/cart";
    }

}
