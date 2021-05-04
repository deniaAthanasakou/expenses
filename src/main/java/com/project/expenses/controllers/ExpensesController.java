package com.project.expenses.controllers;

import com.project.expenses.entities.Amount;
import com.project.expenses.entities.Category;
import com.project.expenses.objects.ExpensesPerCategory;
import com.project.expenses.repositories.AmountRepository;
import com.project.expenses.repositories.CategoryReporistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
        model.addAttribute("showTable", false);
        return "/expensesView";
    }


    @RequestMapping(value="/viewExpensesTable", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String viewExpensesTable(@RequestParam HashMap<String, String> formData, Model model) throws Exception {

        List<Integer> selectedCategoryIds = new ArrayList<>();

        List<Category> categories = categoryRepository.findAll();

        for (Category category: categories){
            if(formData.containsKey(category.getCategoryName())){
                selectedCategoryIds.add(category.getId());
            }
        }

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        Date fromDate = null;
        Date toDate = new Date();
        if(formData.get("fromDate") != null && formData.get("fromDate").length() != 0){
            fromDate = df.parse(formData.get("fromDate"));
        }

        if(formData.get("toDate") != null && formData.get("toDate").length() != 0){
            toDate = df.parse(formData.get("toDate"));
        }

        List<Amount> amounts = null;
        List<ExpensesPerCategory> summarizedAmountsForCategories = null;

        if(fromDate != null){
            //create list for expenses report tab
            amounts = amountRepository.findAmountsByCategoriesAndDates(selectedCategoryIds, fromDate, toDate);
            //create list for category sum tab
            summarizedAmountsForCategories = amountRepository.sumAmountForCategories(selectedCategoryIds, fromDate, toDate);
        }
        else{
            //create list for expenses report tab
            amounts = amountRepository.findAmountsByCategoriesAndToDate(selectedCategoryIds, toDate);
            //create list for category sum tab
            summarizedAmountsForCategories = amountRepository.sumAmountForCategoriesOnlyToDate(selectedCategoryIds, toDate);
        }

        for(Amount amount: amounts){
            Category category = categories.stream().filter(c -> c.getId().equals(amount.getCategoryId())).collect(Collectors.toList()).get(0);
            amount.setCategoryName(category.getCategoryName());
        }

        for(ExpensesPerCategory item : summarizedAmountsForCategories){
            Category category = categories.stream().filter(c -> c.getId().equals(item.getCategoryId())).collect(Collectors.toList()).get(0);
            item.setCategoryName(category.getCategoryName());
        }

        model.addAttribute("amountList", amounts);
        model.addAttribute("sumList", summarizedAmountsForCategories);
        model.addAttribute("categories", categories);
        model.addAttribute("showTable", true);
        return "/expensesView";
    }

}
