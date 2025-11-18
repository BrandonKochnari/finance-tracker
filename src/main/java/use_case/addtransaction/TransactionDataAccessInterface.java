package use_case.addtransaction;

import Entity.Transaction;
import java.util.List;

public interface TransactionDataAccessInterface {
    void save(Transaction transaction);

    List<Transaction> getTransactions();
}
