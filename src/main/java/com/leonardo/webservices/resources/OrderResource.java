package com.leonardo.webservices.resources;

import com.leonardo.webservices.entities.Order;
import com.leonardo.webservices.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    private final OrderService service;

    @Autowired
    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        final List<Order> orders = service.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        final Order order = service.findById(id);
        return ResponseEntity.ok(order);
    }

}
