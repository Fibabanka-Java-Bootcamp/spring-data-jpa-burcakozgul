package com.hkarabakla.services;

import com.hkarabakla.entities.Category;
import com.hkarabakla.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void categoryOperations() {

        Category c1 = new Category();
        c1.setName("Computer Science");
        categoryRepo.save(c1);

        Category c2 = new Category();
        c2.setName("Novel");
        categoryRepo.save(c2);

    }
}
