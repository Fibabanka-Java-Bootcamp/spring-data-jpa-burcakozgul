package com.hkarabakla.repositories;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepo extends CrudRepository<Author, Integer> {

    @Query("select a.books from Author a where a.name=?1")
    List<Book> findBooksByAuthorName(String name);

}