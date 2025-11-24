package Brandon.data;

import Brandon.entities.Budget;
import Brandon.useCase.BudgetDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryBudgetDataAccess implements BudgetDataAccessInterface {

    private final Map<String, Budget> budgets = new HashMap<>();


    @Override
    public Budget getBudgetForMonth(String month) {
        return budgets.get(month);
    }

    @Override
    public void saveBudget(Budget budget) {
        budgets.put(budget.getMonth(), budget);
    }

    @Override
    public void deleteBudget(String monthKey) {
        budgets.remove(monthKey);
    }
}
