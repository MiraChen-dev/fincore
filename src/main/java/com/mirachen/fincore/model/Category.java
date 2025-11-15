package com.mirachen.fincore.model;

public enum Category {
    FOOD, RENT, SALARY, TRANSPORT, ENTERTAINMENT, OTHER;
    public static Category safeOf(String s){
        try{
            return Category.valueOf(s.trim().toUpperCase());
        } catch (Exception e) {return OTHER;}
    }
}
