package com.project.expenses.controllers;

import com.project.expenses.entities.Amount;
import com.project.expenses.entities.Category;
import com.project.expenses.repositories.AmountRepository;
import com.project.expenses.repositories.CategoryReporistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class ExpensesController {
    private final static Logger LOGGER = Logger.getLogger(ExpensesController.class.getName());

    @Autowired
    private CategoryReporistory categoryRepository;

    @Autowired
    private AmountRepository amountRepository;

    @RequestMapping(value="/expenses")
    public String viewExpensesParams(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "/expensesView";
    }

}
