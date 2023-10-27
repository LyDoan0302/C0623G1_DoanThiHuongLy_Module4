package com.example.cart.service;

import com.example.cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();
    Product findById(Long id);
    void update(Product product);
    Optional<Product> findByIdOption(Long id);
}
