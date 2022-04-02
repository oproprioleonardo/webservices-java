package com.leon.portfolio.repositories;

import com.leon.portfolio.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
