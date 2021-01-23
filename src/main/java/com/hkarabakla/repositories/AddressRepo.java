package com.hkarabakla.repositories;

import com.hkarabakla.entities.Address;
import com.hkarabakla.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepo extends CrudRepository<Address, Integer> {

    @Query("select a.user from Address a where a.city=?1")
    List<User> findUserByCity(String cityName);

}
