package com.leonardo.webservices.services;

import com.leonardo.webservices.entities.Product;
import com.leonardo.webservices.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return this.repository.findAll();
    }

    public Product findById(Long id) {
        return this.repository.findById(id).get();
    }
}
