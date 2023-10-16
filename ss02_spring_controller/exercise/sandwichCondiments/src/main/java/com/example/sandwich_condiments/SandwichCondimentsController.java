package com.example.sandwich_condiments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichCondimentsController {
    @GetMapping
    public ModelAndView showSelection(@RequestParam(value = "condiment", required = false) String[] condiment){
        return new ModelAndView("index","condiment",condiment);
    }
}
