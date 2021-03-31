package com.project.expenses.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="CATEGORY_NAME", nullable = false)
    private String categoryName;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
