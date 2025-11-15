package com.mirachen.fincore.app;

import com.mirachen.fincore.repository.InMemoryTransactionRepository;
import com.mirachen.fincore.service.BudgetService;
import com.mirachen.fincore.service.BudgetServiceImpl;

public class Main {
    public static void main(String[] args) {
        var repo = new InMemoryTransactionRepository();
        BudgetService service = new BudgetServiceImpl(repo);
        new ConsoleMenu(service).run();
    }

}
