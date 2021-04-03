package com.project.expenses.repositories;

import com.project.expenses.entities.Amount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmountRepository extends JpaRepository<Amount, Long> {
}
