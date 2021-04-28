package com.project.expenses.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "AMOUNTS")
public class Amount implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="CATEGORY_ID", nullable = false)
    private Integer categoryId;

    @Column(name="AMOUNT", nullable = false)
    private Float amount;

    @Column(name="DATE_ADDED", nullable = false)
    private Date dateAdded;

    @Column(name="DESCRIPTION")
    private String description;

    private String categoryName;

    public Amount() {
    }

    public Amount(Integer categoryId, Float amount, String description, Date dateAdded) {
        this.categoryId = categoryId;
        this.amount = amount;
        this.description = description;
        this.dateAdded = dateAdded;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
