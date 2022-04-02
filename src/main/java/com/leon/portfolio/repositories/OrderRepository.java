package com.leon.portfolio.repositories;

import com.leon.portfolio.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
