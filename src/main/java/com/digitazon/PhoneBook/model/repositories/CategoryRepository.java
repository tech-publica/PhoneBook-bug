package com.digitazon.PhoneBook.model.repositories;

import com.digitazon.PhoneBook.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
