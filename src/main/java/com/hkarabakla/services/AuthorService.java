package com.hkarabakla.services;

import com.hkarabakla.entities.Author;
import com.hkarabakla.entities.Book;
import com.hkarabakla.repositories.AuthorRepo;
import com.hkarabakla.repositories.BookRepo;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class AuthorService {

    private final AuthorRepo authorRepo;

    private final BookRepo bookRepo;

    public AuthorService(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }
    public void authorOperations(){
        List<Book> b1 = bookRepo.findByName("Spring in Action");
        List<Book> b2 = bookRepo.findByName("Modular Java");
        List<Book> b3 = new ArrayList<>();
        b3.addAll(b1);
        b3.addAll(b2);


        Author author = new Author();
        author.setName("Craig Walls");
        author.setBooks(b3);
        authorRepo.save(author);

        Author author1 = new Author();
        author1.setName("Ryan Breidenbach");
        author1.setBooks(b1);
        authorRepo.save(author1);

        Author author2 = new Author();
        author2.setName("Sabahattin Ali");
        author2.setBooks(bookRepo.findByName("Kurk Mantolu Madonna"));
        authorRepo.save(author2);
    }
    public void findBooksByAuthorName(){
        List<Book> books= authorRepo.findBooksByAuthorName("Craig Walls");
        System.out.println(books);
    }

}
