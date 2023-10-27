package com.example.cart.service;

import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Optional<Product> findByIdOption(Long id) {
        return iProductRepository.findById(id);
    }
}
