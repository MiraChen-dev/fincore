package com.mirachen.fincore.service;
import com.mirachen.fincore.service.BudgetServiceImpl;
import com.mirachen.fincore.repository.InMemoryTransactionRepository;
import com.mirachen.fincore.model.Category;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.*;

public class BudgetServiceImplTest {
    @Test
    void incomeIncreasesBalance() {
        var service = new BudgetServiceImpl(new InMemoryTransactionRepository());
        service.addIncome(100, LocalDate.now(), Category.SALARY, "test payment");
        assertEquals(100, service.getBalance(),1e-6);
    }

    @Test
    void expenseDecreasesBalance(){
        var service = new BudgetServiceImpl(new InMemoryTransactionRepository());
        service.addIncome(1000, LocalDate.now(), Category.SALARY, "test payment");
        service.addExpense(800, LocalDate.now(), Category.RENT, "this month rent");
        assertEquals(200,service.getBalance(),1e-6);
    }
}
