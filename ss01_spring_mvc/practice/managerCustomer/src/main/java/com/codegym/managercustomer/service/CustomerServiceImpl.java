package com.codegym.managercustomer.service;

import com.codegym.managercustomer.model.Customer;
import com.codegym.managercustomer.repository.CustomerRepositoryImpl;
import com.codegym.managercustomer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{
   @Autowired ICustomerRepository customerRepository;
    @Override
    public List<Customer> showCustomerList() {
        return customerRepository.showCustomerList();
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }
}
