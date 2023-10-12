package com.codegym.exchangemoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class exchangeController {
    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index");
    }
    @PostMapping
    public ModelAndView exchangeMoney(@RequestParam double usd){
        double vnd = usd * 20000;
        return new ModelAndView("index","vnd", vnd);
    }
    @GetMapping("/result")
    public ModelAndView exchangeMoney2(@RequestParam double usd){
        double vnd = usd * 20000;
        return new ModelAndView("index","vnd", vnd);
    }

}
