package com.leonardo.webservices.services;

import com.leonardo.webservices.entities.Category;
import com.leonardo.webservices.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return this.repository.findAll();
    }

    public Category findById(Long id) {

        return this.repository.findById(id).get();
    }
}
