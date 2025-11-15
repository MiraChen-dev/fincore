package com.mirachen.fincore.service;
import com.mirachen.fincore.model.Expense;
import com.mirachen.fincore.model.Income;
import com.mirachen.fincore.model.Transaction;
import com.mirachen.fincore.model.Category;
import com.mirachen.fincore.repository.TransactionRepository;

import java.time.*;
import java.util.*;

public class BudgetServiceImpl implements BudgetService{
    private final TransactionRepository repo;
    public BudgetServiceImpl(TransactionRepository repo){this.repo=repo;}

    @Override
    public Income addIncome(double amount, LocalDate date, Category category,String description){
        Income in = new Income(amount, date, category, description);
        repo.save(in);
        return in;
    }

    @Override
    public Expense addExpense(double amount, LocalDate date, Category category,String description){
        Expense out = new Expense(amount, date, category, description);
        repo.save(out);
        return out;
    }

    @Override
    public double getBalance(){
        return repo.findAll().stream()
                .mapToDouble(t -> t.isIncome() ? t.getAmount() : -t.getAmount())
                .sum();
    }

    @Override
    public List<Transaction> listTransactions() {
        return repo.findAll();
    }

    @Override
    public List<Transaction> sortByAmount(){
        return repo.findAll().stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .toList();
    }

    @Override
    public List<Transaction> findByCategory(Category category){
        return repo.findAll().stream()
                .filter(t -> t.getCategory() == category)
                .toList();
    }
}
