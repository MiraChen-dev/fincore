package com.mirachen.fincore.repository;
import com .mirachen.fincore.model.Transaction;
import java.util.*;

public class InMemoryTransactionRepository implements TransactionRepository{
    private final List<Transaction> data = new ArrayList<>();
    @Override
    public void save(Transaction tx) {
        data.add(tx);
    }
    @Override
    public List<Transaction> findAll() {
        return Collections.unmodifiableList(data);
    }
}
