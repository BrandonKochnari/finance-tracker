package use_case.AddTransaction;

import Entity.Transaction;

public interface AddTransactionOutputBoundary {
    void prepareSuccessView(AddTransactionResponseModel responseModel);
    void prepareFailureView(String errorMessage);
}
