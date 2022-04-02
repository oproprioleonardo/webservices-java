package com.leon.portfolio.config;

import com.google.common.collect.Lists;
import com.leon.portfolio.entities.Order;
import com.leon.portfolio.entities.User;
import com.leon.portfolio.repositories.OrderRepository;
import com.leon.portfolio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        final User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", Lists.newArrayList());
        final User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", Lists.newArrayList());

        final Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        final Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        final Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
