package com.codegym.customermanagerthymeleaf.service;

import com.codegym.customermanagerthymeleaf.model.Customer;
import com.codegym.customermanagerthymeleaf.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }
}
