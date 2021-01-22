package com.hkarabakla.repositories;

import com.hkarabakla.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, String> {

    List<Book> findByNameIgnoreCaseContaining(String name);

    List<Book> findByName(String name);
}
