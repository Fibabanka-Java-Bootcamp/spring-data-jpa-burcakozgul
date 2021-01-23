package com.hkarabakla;

import com.hkarabakla.services.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.hkarabakla");
        appContext.refresh();

        CategoryService categoryService = (CategoryService) appContext.getBean("categoryService");
        categoryService.categoryOperations();

        BookService bookService = (BookService) appContext.getBean("bookService");
        bookService.bookOperations();

        AuthorService authorService = (AuthorService) appContext.getBean("authorService");
        authorService.authorOperations();
        authorService.findBooksByAuthorName();

        bookService.findByBookName();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userOperations();

        AddressService addressService = (AddressService) appContext.getBean("addressService");
        addressService.findUsersByCityName();

        OrderService orderService = (OrderService) appContext.getBean("orderService");
        orderService.orderOperations();

        userService.findOrdersByUserName();



        appContext.close();
    }
}
