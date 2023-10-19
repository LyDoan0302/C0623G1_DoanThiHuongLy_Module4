package com.codegym.customermanagerjpa.controller;

import com.codegym.customermanagerjpa.model.Customer;
import com.codegym.customermanagerjpa.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView findAllCustomer() {
        return new ModelAndView("index", "customers", customerService.findAll());
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable long id ) {
        return new ModelAndView("edit", "customer", customerService.findById(id));
    }
    @PostMapping("/edit")
    public String editCustomerInfo(Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/{id}/view")
    public ModelAndView showCustomerByDetail(@PathVariable Long id) {
        return new ModelAndView("view", "customer", customerService.findById(id));
    }
    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "customer", new Customer());
    }
    @PostMapping("/create")
    public String createCustomer(@RequestParam Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/search")
    public ModelAndView searchCustomerByName(@RequestParam String name) {
        return new ModelAndView("search", "customers", customerService.findByName(name));
    }

}
