package com.digitazon.PhoneBook.controllers;

import com.digitazon.PhoneBook.model.entities.Category;
import com.digitazon.PhoneBook.model.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    private CategoryRepository categoryRepo;

    public CategoryController(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public Iterable<Category> showAllCategory() {
        Iterable<Category> categories = categoryRepo.findAll();
        return categories;
    }
}
