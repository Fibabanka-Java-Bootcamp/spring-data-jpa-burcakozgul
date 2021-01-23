package com.hkarabakla.services;

import com.hkarabakla.entities.User;
import com.hkarabakla.repositories.AddressRepo;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AddressService {

    private final AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public void findUsersByCityName(){
        List<User> users = addressRepo.findUserByCity("Istanbul");
        System.out.println("Users living in Istanbul");
        System.out.println(users);
    }
}
