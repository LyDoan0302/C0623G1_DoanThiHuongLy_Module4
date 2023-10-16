package com.codegym.managercustomer.repository;

import com.codegym.managercustomer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository

public class CustomerRepositoryImpl implements ICustomerRepository{
    private static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Nguyen Van A", "a@gmail", "Da Nang"));
        customerList.add(new Customer(2, "Nguyen Van B", "b@gmail", "Da Nang"));
        customerList.add(new Customer(3, "Nguyen Van C", "c@gmail", "Da Nang"));
        customerList.add(new Customer(4, "Nguyen Van D", "d@gmail", "Da Nang"));
        customerList.add(new Customer(5, "Nguyen Van E", "e@gmail", "Da Nang"));
    }
    @Override
    public List<Customer> showCustomerList() {
        return customerList;
    }

    @Override
    public Customer findCustomerById(int id) {
        Customer customer = null;
        for (Customer cs: customerList) {
            if(id == cs.getId()) {
                String name = cs.getName();
                String email = cs.getEmail();
                String address = cs.getAddress();
                customer = new Customer(id, name, email, address);
            }
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        int index;
        for (Customer customerValue: customerList) {
            if (customerValue.getId() == customer.getId()){
                index = customerList.indexOf(customerValue);
                customerList.set(index,customer);
            }
        }
    }
}
