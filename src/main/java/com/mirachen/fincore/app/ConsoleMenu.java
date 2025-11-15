package com.mirachen.fincore.app;

import com.mirachen.fincore.model.Category;
import com.mirachen.fincore.service.BudgetService;

import java.time.LocalDate;
import java.util.*;

public class ConsoleMenu {
    private final BudgetService service;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(BudgetService service) {
        this.service = service;
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("""
                    Welcome to Fincore! Here is the Menu:
                    1.Add income
                    2.Add expense
                    3.List transactions
                    4.View balance
                    5.Search by category
                    6.Sort by amount
                    7.Exit
                    """);
            System.out.println("Please input a number to choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addIncome();
                case 2 -> addExpense();
                case 3 -> service.listTransactions().forEach(System.out::println);
                case 4 -> System.out.println("Balance: " + service.getBalance());
                case 5 -> searchByCategory();
                case 6 -> service.sortByAmount().forEach(System.out::println);
                case 7 -> running = false;
                default -> System.out.println("Invalid input, please try again.");
            }
            System.out.println();
        }
        System.out.println("Bye! see you next time:)");
    }

    private void addIncome() {
        double amount = readAmount("Income amount is: ");
        System.out.println("Add note: ");
        String desc = scanner.nextLine();
        service.addIncome(amount, LocalDate.now(), Category.SALARY, desc);
        System.out.println("Successfully added Income!");
    }

    private void addExpense() {
        double amount = readAmount("Expense amount is: ");
        System.out.println("Category of this expense(FOOD/RENT/OTHER): ");
        Category cat = Category.safeOf(scanner.nextLine());
        System.out.println("Add note: ");
        String desc = scanner.nextLine();
        service.addExpense(amount, LocalDate.now(), cat, desc);
        System.out.println("Successfully added Expense!");
    }

    private void searchByCategory() {
        System.out.print("Category is: ");
        Category cat = Category.safeOf(scanner.nextLine());
        service.findByCategory(cat).forEach(System.out::println);
    }

    private double readAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double a = Double.parseDouble(scanner.nextLine().trim());
                if (a <= 0) throw new IllegalArgumentException("amount must be positive!");
                return a;
            } catch (Exception e) {
                System.out.println("invalid amount input, please try again");
            }
        }
    }


}

