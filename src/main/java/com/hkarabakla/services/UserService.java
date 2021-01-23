package com.hkarabakla.services;

import com.hkarabakla.entities.*;
import com.hkarabakla.repositories.UserRepo;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo repo) {
        this.userRepo = repo;
    }

    public void userOperations() {
        User u = new User();
        u.setName("Burcak");

        Address address = new Address();
        address.setStreet("Brooklyn");
        address.setNumber("7");
        address.setCity("New York");

        u.setAddress(address);
        userRepo.save(u);

        User u2 = new User();
        u2.setName("Elif");

        Address address1 = new Address();
        address1.setStreet("Yunus sokak");
        address1.setNumber("20");
        address1.setCity("Istanbul");

        u2.setAddress(address1);
        userRepo.save(u2);

        User u3 = new User();
        u3.setName("Rich");

        Address address2 = new Address();
        address2.setStreet("Lara");
        address2.setNumber("18");
        address2.setCity("Istanbul");

        u3.setAddress(address2);
        userRepo.save(u3);

    }

    public void findOrdersByUserName(){
        List<Order> orders = userRepo.findOrderByUserName("Burcak");
        System.out.println("Burcak's orders: ");
        System.out.println(orders);

        System.out.println("Elif's orders: ");
        List<Order> orders1 = userRepo.findOrderByUserName("Elif");
        System.out.println(orders1);
    }

}
