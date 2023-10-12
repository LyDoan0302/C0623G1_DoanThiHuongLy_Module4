package com.codegym.managercustomer.repository;

import com.codegym.managercustomer.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> showCustomerList();
    Customer findCustomerById(int id);
}
