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
public class CategoryExpensesController {

    private final static Logger LOGGER = Logger.getLogger(CategoryExpensesController.class.getName());

    @Autowired
    private CategoryReporistory categoryRepository;

    @Autowired
    private AmountRepository amountRepository;

    @RequestMapping(value="/expensesViewForm", method = RequestMethod.GET)
    public String viewExpensesForm(@RequestParam String categoryName, Model model) {
        model.addAttribute("category", categoryName);
        return "/categoryExpensesAdd";
    }

    @RequestMapping(value="/expensesAdd", method = RequestMethod.POST)
    public String addExpenses(@RequestParam String categoryName, @RequestParam Float amount, @RequestParam String description, Model model) throws Exception {
        //column CATEGORY_NAME is unique, so the list will only contain one element
        List<Category> categories = categoryRepository.findByCategoryName(categoryName);
        if(categories.size() == 0){
            throw new Exception("No category was found with name: " + categoryName);
        }
        else if(categories.size() > 1){
            throw new Exception("There were more than one categories with name: " + categoryName);
        }

        Amount amountEntity = new Amount(categories.get(0).getId(), amount, description, new Timestamp(new Date().getTime()));
        amountRepository.save(amountEntity);

        List<Category> allCategories = categoryRepository.findAll();
        model.addAttribute("categories", allCategories);
        return "/categories";
    }

}
