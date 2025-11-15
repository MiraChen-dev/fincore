package com.mirachen.fincore.model;

import java.time.*;

public class Expense extends Transaction {
    public Expense(double amount, LocalDate date, Category category, String description){
        super(amount, date, category, description);
    }
    @Override
    public boolean isIncome() {return false;}
}

