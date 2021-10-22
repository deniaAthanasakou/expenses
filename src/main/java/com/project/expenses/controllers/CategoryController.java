package com.project.expenses.controllers;

import com.project.expenses.entities.Category;
import com.project.expenses.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class CategoryController {

    private final static Logger LOGGER = Logger.getLogger(CategoryController.class.getName());

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/categories")
    public String viewCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "/categories";
    }

    @RequestMapping(value="/categoriesAdd", method = RequestMethod.POST)
    public String addCategory(@RequestParam String categoryName, Model model){
        Category newCategory = new Category(categoryName);
        categoryRepository.save(newCategory);

        List<Category> allCategories = categoryRepository.findAll();
        model.addAttribute("categories", allCategories);
        return "/categories";
    }

}
