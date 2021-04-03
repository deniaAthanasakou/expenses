package com.project.expenses.repositories;

import com.project.expenses.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryReporistory extends JpaRepository<Category, Long> {

    List<Category> findByCategoryName(String categoryName);

}
