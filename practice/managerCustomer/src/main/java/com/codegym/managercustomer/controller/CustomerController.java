package com.codegym.managercustomer.controller;

import com.codegym.managercustomer.model.Customer;
import com.codegym.managercustomer.service.ICustomerService;
import com.ibm.j9ddr.vm29.pointer.generated._jfieldIDPointer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/customer")
    public String showList(Model model) {
        model.addAttribute("customerList", customerService.showCustomerList());
        return "index";
    }

    @GetMapping
    public String showList1(Model model) {
        model.addAttribute("customerList", customerService.showCustomerList());
        return "list";
    }
    @GetMapping("info")
    public ModelAndView showCustomerbyDetail(@RequestParam int id) {
        Customer customer = customerService.findCustomerById(id);
        return new ModelAndView("info", "customer", customer);
    }

}
