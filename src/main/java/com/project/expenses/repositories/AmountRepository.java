package com.project.expenses.repositories;

import com.project.expenses.entities.Amount;
import com.project.expenses.objects.ExpensesPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Collection;
import java.util.List;

public interface AmountRepository extends JpaRepository<Amount, Long> {

    @Query("SELECT amount FROM Amount amount WHERE amount.categoryId IN :categoryIds and amount.dateAdded >= :dateFrom and amount.dateAdded <= :dateTo")
    List<Amount> findAmountsByCategoriesAndDates(@Param("categoryIds") Collection<Integer> categoryIds, @Param("dateFrom") Date dateFrom, @Param("dateTo")  Date dateTo);

    @Query(value = "select new com.project.expenses.objects.ExpensesPerCategory(amountEntry.categoryId, sum(amountEntry.amount)) FROM Amount amountEntry" +
            " WHERE amountEntry.categoryId IN :categoryIds and amountEntry.dateAdded >= :dateFrom and amountEntry.dateAdded <= :dateTo group by amountEntry.categoryId")
    List<ExpensesPerCategory> sumAmountForCategories(@Param("categoryIds") Collection<Integer> categoryIds, @Param("dateFrom") Date dateFrom, @Param("dateTo")  Date dateTo);

}
