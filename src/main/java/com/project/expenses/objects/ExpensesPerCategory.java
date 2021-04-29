package com.project.expenses.objects;

public class ExpensesPerCategory {

    private String categoryName;
    private Integer categoryId;
    private Double sum;

    public ExpensesPerCategory() {
    }

    public ExpensesPerCategory(Integer categoryId, Double sum) {
        this.categoryId = categoryId;
        this.sum = sum;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
