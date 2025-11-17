package use_case.AddTransaction;

import Entity.Transaction;

public interface AddTransactionInputBoundary {
    void execute(AddTransactionRequestModel requestModel);
}
