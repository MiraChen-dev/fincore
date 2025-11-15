package com.mirachen.fincore.repository;
import com.mirachen.fincore.model.Transaction;
import java.util.*;

public interface TransactionRepository {
    void save(Transaction tx);
    List<Transaction> findAll();
}
