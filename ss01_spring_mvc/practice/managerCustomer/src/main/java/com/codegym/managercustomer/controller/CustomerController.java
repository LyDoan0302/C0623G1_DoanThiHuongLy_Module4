package com.codegym.managercustomer.controller;

import com.codegym.managercustomer.model.Customer;
import com.codegym.managercustomer.service.ICustomerService;
import com.ibm.j9ddr.vm29.pointer.generated._jfieldIDPointer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/customer")
    public String showList(Model model) {
        model.addAttribute("customerList", customerService.showCustomerList());
        return "index";
    }

    @GetMapping
    public ModelAndView showList1() {
        return new ModelAndView("list","customerList", customerService.showCustomerList());
    }
    @GetMapping("info")
    public ModelAndView showCustomerbyDetail(@RequestParam int id) {
        Customer customer = customerService.findCustomerById(id);
        return new ModelAndView("info", "customer", customer);
    }

  @GetMapping("update/{id}")
    public ModelAndView showFormUpdate(@PathVariable(value="id") int id) {
    return new ModelAndView("update","customer",customerService.findCustomerById(id));
  }
  @PostMapping("update/{id}")
    public ModelAndView updateToList(@PathVariable(value="id") Integer id ,
                                     @RequestParam String name, String email, String address) {
    Customer customer = new Customer(id, name, email, address);
    customerService.updateCustomer(customer);
    return showList1();
  }
}
