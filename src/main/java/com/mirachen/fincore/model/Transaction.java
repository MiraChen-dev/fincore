package com.mirachen.fincore.model;

import java.util.*;
import java.time.*;

public abstract class Transaction {
    private final String id = UUID.randomUUID().toString();
    private final LocalDate date;
    private final Category category;
    private final String description;
    private final double amount;

    protected Transaction(double amount, LocalDate date, Category category, String description){
        if (amount <=0) throw new IllegalArgumentException("amount must be positive!");
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    public String getId() {return id;}
    public LocalDate getDate() {return date;}
    public Category getCategory() {return category;}
    public String getDescription() {return description;}
    public double getAmount() {return amount;}

    public abstract boolean isIncome();

    @Override
    public String toString(){
        return((isIncome() ? "[IN]" : "[OUT]") + " " + amount + " " +category+" "+description+" "+date);
    }
}
//change