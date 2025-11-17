package use_case.AddTransaction;

import Entity.Transaction;
import java.util.List;

public interface TransactionDataAccessInterface {
    void save(Transaction transaction);

    List<Transaction> getTransactions();
}
