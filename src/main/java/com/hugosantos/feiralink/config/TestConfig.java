package com.hugosantos.feiralink.config;

import com.hugosantos.feiralink.model.entities.Category;
import com.hugosantos.feiralink.model.entities.Client;
import com.hugosantos.feiralink.model.entities.Order;
import com.hugosantos.feiralink.model.entities.Product;
import com.hugosantos.feiralink.model.entities.enums.OrderStatus;
import com.hugosantos.feiralink.repositories.CategoryRepository;
import com.hugosantos.feiralink.repositories.OrderRepository;
import com.hugosantos.feiralink.repositories.ProductRepository;
import com.hugosantos.feiralink.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Client u1 = new Client(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Client u2 = new Client(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category cat1 = new Category(null, "Carnes");
        Category cat2 = new Category(null, "Bebidas");
        Category cat3 = new Category(null, "Peixes");
        Category cat4 = new Category(null, "Frutas e Verduras");
        Category cat5 = new Category(null, "Ervas");
        Category cat6 = new Category(null, "Farinhas");
        Category cat7 = new Category(null, "Polpas e Frutas");
        Category cat8 = new Category(null, "Refeições");

        Product p1 = new Product(null, "Farinha d'água", "Farinha d'água.", 20.0, "", cat6);
        Product p2 = new Product(null, "Açaí", "Açaí do grosso!", 40.0, "", cat8);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
        productRepository.saveAll(Arrays.asList(p1, p2));
    }
}
