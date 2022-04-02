package com.leon.portfolio.repositories;

import com.leon.portfolio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
