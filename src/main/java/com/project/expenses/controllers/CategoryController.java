package com.project.expenses.controllers;

import com.project.expenses.entities.Category;
import com.project.expenses.repositories.CategoryReporistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class CategoryController {

    private final static Logger LOGGER = Logger.getLogger(CategoryController.class.getName());

    @Autowired
    private CategoryReporistory categoryRepository;

    @RequestMapping("/categories")
    public String viewCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }

}
