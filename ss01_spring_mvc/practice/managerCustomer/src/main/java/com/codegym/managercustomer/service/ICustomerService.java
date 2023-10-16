package com.codegym.managercustomer.service;

import com.codegym.managercustomer.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showCustomerList();
    Customer findCustomerById(int id);
    void updateCustomer(Customer customer);
}
