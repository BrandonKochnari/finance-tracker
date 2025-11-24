package Brandon.useCase;

import Brandon.entities.Budget;

public interface BudgetDataAccessInterface {
    Budget getBudgetForMonth(String month);
    void saveBudget(Budget budget);
    void deleteBudget(String monthKey);
}
