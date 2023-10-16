package com.codegym.calculator.controller;

import com.codegym.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;
    @GetMapping
    public ModelAndView showCalculationHome(){
        return new ModelAndView("index");
    }
    @PostMapping
    public ModelAndView calculate(@RequestParam double number1,@RequestParam double number2, String type) {
        try {
            return new ModelAndView("index", "result", calculatorService.calculate(number1, number2, type));
        } catch (ArithmeticException e) {
            return new ModelAndView("index", "error", "the dividend is not 0");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ModelAndView("index", "error", "ERROR");
        }

    }
}
