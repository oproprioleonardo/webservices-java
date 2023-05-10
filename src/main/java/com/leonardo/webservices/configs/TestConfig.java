package com.leonardo.webservices.configs;

import com.leonardo.webservices.entities.*;
import com.leonardo.webservices.entities.enums.OrderStatus;
import com.leonardo.webservices.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        final Category cat1 = new Category(null, "Electronics");
        final Category cat2 = new Category(null, "Books");
        final Category cat3 = new Category(null, "Computers");

        final Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        final Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 6190.0, "");
        final Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 10250.0, "");
        final Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 4200.0, "");
        final Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.addCategory(cat2);
        p2.addCategory(cat1);
        p2.addCategory(cat3);
        p3.addCategory(cat3);
        p4.addCategory(cat3);
        p5.addCategory(cat2);

        this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        final User leo = new User(null, "leonardo", "leonardo@gmail.com", "13997438204", "leo1810");
        final User sara = new User(null, "aaaaaaa", "aaaaaaa@gmail.com", "13988570657", "aaaaaa0501");

        final Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, leo);
        final Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, sara);
        final Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, leo);

        this.userRepository.saveAll(Arrays.asList(leo, sara));
        this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        final OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        final OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        final OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        final OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        final Payment payment1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(payment1);

        orderRepository.save(o1);
    }
}
