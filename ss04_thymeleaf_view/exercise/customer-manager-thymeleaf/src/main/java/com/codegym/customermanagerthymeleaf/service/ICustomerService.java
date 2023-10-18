package com.codegym.customermanagerthymeleaf.service;

import com.codegym.customermanagerthymeleaf.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
    List<Customer> findCustomerByName(String name);
}
