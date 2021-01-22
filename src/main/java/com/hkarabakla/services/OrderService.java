package com.hkarabakla.services;

import com.hkarabakla.entities.Order;
import com.hkarabakla.entities.User;
import com.hkarabakla.repositories.BookRepo;
import com.hkarabakla.repositories.OrderRepo;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class OrderService {

    private final OrderRepo orderRepo;

    private final UserRepo userRepo;

    private final BookRepo bookRepo;

    public OrderService(OrderRepo orderRepo, UserRepo userRepo, BookRepo bookRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    public void orderOperations() {
        Order order = new Order();
        order.setCreatedDate(LocalDate.now());
        order.setUser(userRepo.findByName("Burcak"));
        order.setBooks(bookRepo.findByName("Modular Java"));
        order.setTotal(120.6);
        orderRepo.save(order);


        Order order1 = new Order();
        order1.setCreatedDate(LocalDate.now());
        order1.setUser(userRepo.findByName("Burcak"));
        order1.setBooks(bookRepo.findByName("Spring in Action"));
        order1.setTotal(100.5);
        orderRepo.save(order1);

        List<Order> orders = Arrays.asList(order, order1);
        User user = userRepo.findByName("Burcak");
        user.setOrders(orders);

        Order order2 = new Order();
        order2.setCreatedDate(LocalDate.now());
        order2.setUser(userRepo.findByName("Elif"));
        order2.setBooks(bookRepo.findByName("Spring in Action"));
        order2.setTotal(105.0);
        orderRepo.save(order2);

        Order order3 = new Order();
        order3.setCreatedDate(LocalDate.now());
        order3.setUser(userRepo.findByName("Elif"));
        order3.setBooks(bookRepo.findByName("Kurk Mantolu Madonna"));
        order3.setTotal(30.3);
        orderRepo.save(order3);

        List<Order> orders1 = Arrays.asList(order2, order3);
        User user1 = userRepo.findByName("Elif");
        user1.setOrders(orders1);

    }
}
