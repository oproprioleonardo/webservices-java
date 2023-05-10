package com.leonardo.webservices.services;

import com.leonardo.webservices.entities.Order;
import com.leonardo.webservices.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return this.repository.findAll();
    }

    public Order findById(Long id) {
        return this.repository.findById(id).get();
    }
}
