package com.project.expenses.repositories;

import com.project.expenses.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryReporistory extends JpaRepository<Category, Long> {
}
