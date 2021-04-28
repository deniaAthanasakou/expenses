package com.project.expenses.repositories;

import com.project.expenses.entities.Amount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Collection;
import java.util.List;

public interface AmountRepository extends JpaRepository<Amount, Long> {

    @Query("SELECT amount FROM Amount amount WHERE amount.categoryId IN :categoryIds and amount.dateAdded >= :dateFrom and amount.dateAdded <= :dateTo")
    List<Amount> findAmountsByCategoriesAndDates(@Param("categoryIds") Collection<Integer> categoryIds, @Param("dateFrom") Date dateFrom, @Param("dateTo")  Date dateTo);

}
