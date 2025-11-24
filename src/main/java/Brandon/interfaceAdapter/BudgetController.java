package Brandon.interfaceAdapter;

import Brandon.useCase.BudgetInputBoundary;
import Brandon.useCase.BudgetInputData;

public class BudgetController {

    private final BudgetInputBoundary interactor;

    public BudgetController(BudgetInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void setBudget(String month, float limit, float totalSpent) {
        BudgetInputData inputData = new BudgetInputData(month, limit, totalSpent);
        interactor.execute(inputData);
    }
}
