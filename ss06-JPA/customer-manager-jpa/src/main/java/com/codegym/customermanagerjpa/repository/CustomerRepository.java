package com.codegym.customermanagerjpa.repository;

import com.codegym.customermanagerjpa.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id=:id", Customer.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }

    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if(customer != null) {
            entityManager.remove(customer);
        }

    }

    @Override
    public List<Customer> findByName(String name) {
       TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.name like :name", Customer.class);
       query.setParameter("name", '%' + name + '%');
       try{
           return query.getResultList();
       } catch (NoResultException e) {
           return null;
       }
    }
}
