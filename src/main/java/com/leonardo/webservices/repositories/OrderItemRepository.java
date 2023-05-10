package com.leonardo.webservices.repositories;

import com.leonardo.webservices.entities.OrderItem;
import com.leonardo.webservices.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}