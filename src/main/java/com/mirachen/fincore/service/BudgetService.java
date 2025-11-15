package com.mirachen.fincore.service;
import com.mirachen.fincore.model.Expense;
import com.mirachen.fincore.model.Income;
import com.mirachen.fincore.model.Transaction;
import com.mirachen.fincore.model.Category;
import java.time.*;
import java.util.*;
public interface BudgetService {
    Income addIncome(double amount, LocalDate date, Category category, String description);
    Expense addExpense(double amount, LocalDate date, Category category, String description);

    double getBalance();
    List<Transaction> listTransactions();
    List<Transaction> sortByAmount();
    List<Transaction> findByCategory(Category category);
}
