package com.leonardo.webservices.resources;

import com.leonardo.webservices.entities.Product;
import com.leonardo.webservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    private final ProductService service;

    @Autowired
    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        final List<Product> products = service.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        final Product product = service.findById(id);
        return ResponseEntity.ok(product);
    }

}
