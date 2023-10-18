package com.codegym.customermanagerthymeleaf.repository;

import com.codegym.customermanagerthymeleaf.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository implements ICustomerRepository{

    private static final Map<Integer, Customer> customerListMap;
    static {
        customerListMap = new HashMap<>();
        customerListMap.put(1, new Customer(1, "Nguyen Van A", "a@gmail", "Da Nang"));
        customerListMap.put(2, new Customer(2, "Nguyen Van B", "b@gmail", "Da Nang"));
        customerListMap.put(3, new Customer(3, "Nguyen Van C", "c@gmail", "Da Nang"));
        customerListMap.put(4, new Customer(4, "Nguyen Van D", "d@gmail", "Da Nang"));
    }

    @Override
    public List<Customer> findAll() {
      return new ArrayList<>(customerListMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerListMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
       return customerListMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerListMap.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customerListMap.remove(id);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        for(Map.Entry<Integer, Customer> cus: customerListMap.entrySet()) {
            if(cus.getValue().getName().contains(name)){
                customerList.add(cus.getValue());
            }
        }
        return customerList;
    }
}
