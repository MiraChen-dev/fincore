package com.mirachen.fincore.model;

import java.time.*;

public class Income extends Transaction {
    public Income(double amount, LocalDate date, Category category, String description){
        super(amount, date, category, description);
    }
    @Override
    public boolean isIncome() {return true;}
}
