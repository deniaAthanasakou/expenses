package com.project.expenses.controllers;

import com.project.expenses.entities.Category;
import com.project.expenses.repositories.CategoryReporistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ExpensesController {

    private final static Logger LOGGER = Logger.getLogger(ExpensesController.class.getName());

    @Autowired
    private CategoryReporistory categoryRepository;

    @RequestMapping(value="/expenses/add/view", method = RequestMethod.GET)
    public String viewExpensesForm(@RequestParam String categoryName, Model model) {
        model.addAttribute("category", categoryName);
        return "categoryExpensesAdd";
    }

    @RequestMapping("/expenses/add")
    public String addExpenses(@RequestParam String categoryName, @RequestParam Double amount, @RequestParam String description, Model model) {
        //TODO entry
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }
}
