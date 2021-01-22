package com.hkarabakla.services;

import com.hkarabakla.entities.*;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo repo) {
        this.userRepo = repo;
    }

    public void userOperations() {
        User u = new User();
        u.setName("Burcak");

        Address address = new Address();
        address.setStreet("Gazo sokak");
        address.setNumber("7");
        address.setCity("Istanbul");

        u.setAddress(address);
        userRepo.save(u);

        User u2 = new User();
        u2.setName("Elif");

        Address address1 = new Address();
        address1.setStreet("Yunus sokak");
        address1.setNumber("20");
        address1.setCity("Izmır");

        u2.setAddress(address1);
        userRepo.save(u2);

    }

    public void findOrdersByUserName(){
        List<Order> orders = userRepo.findOrderByUserName("Burcak");
        System.out.println(orders);

        List<Order> orders1 = userRepo.findOrderByUserName("Elif");
        System.out.println(orders1);

    }
}
