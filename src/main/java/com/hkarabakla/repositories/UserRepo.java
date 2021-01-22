package com.hkarabakla.repositories;

import com.hkarabakla.entities.Order;
import com.hkarabakla.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {

    User findByName(String name);

    @Query("select u.orders from User u where u.name=?1")
    List<Order> findOrderByUserName(String name);
}
