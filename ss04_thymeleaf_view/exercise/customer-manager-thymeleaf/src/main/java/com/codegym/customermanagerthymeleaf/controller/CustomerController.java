package com.codegym.customermanagerthymeleaf.controller;

import com.codegym.customermanagerthymeleaf.model.Customer;
import com.codegym.customermanagerthymeleaf.service.CustomerService;
import com.codegym.customermanagerthymeleaf.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("/index", "customers", customerService.findAll());
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/create", "customer", new Customer());
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        System.out.println(customer);
        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("customer","create");
        redirectAttributes.addFlashAttribute("success", "added customer!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        return new ModelAndView("update", "customer", customerService.findById(id));
    }
    @PostMapping("/edit")
    public String updateCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer.getId(), customer);
        redirectAttributes.addFlashAttribute("success", "Updated customer!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Deleted customer!");
        return new ModelAndView("redirect:/customer");
    }
    @GetMapping("/{id}/view")
    public ModelAndView viewCustomerByDetail(@PathVariable Integer id) {
        return new ModelAndView("detail", "customer", customerService.findById(id));
    }
    @PostMapping("/search")
    public String searchCustomerByName(@RequestParam String name, Model model) {
        List<Customer> customers = customerService.findCustomerByName(name);
        model.addAttribute("customers", customers);
        return "/search";
    }

}
