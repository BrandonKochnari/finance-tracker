package use_case.graph;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import Entity.Transaction;
import use_case.graph.GraphDataAccessInterface;

public class GraphInteractor implements GraphInputBoundary {
    private final GraphDataAccessInterface dataAccessObject;
    private final GraphOutputBoundary graphPresenter;

    public GraphInteractor(GraphDataAccessInterface dataAccessInterface, GraphOutputBoundary graphOutputBoundary) {
        this.graphPresenter = graphOutputBoundary;
        this.dataAccessObject = dataAccessInterface;
    }

    @Override
    public void execute(GraphInputData graphInputData) {
        String selectedRange = graphInputData.getRange();
        String selectedType = graphInputData.getTransactionType();
        Map<Integer, Float> bar = new HashMap<>();
        Map<String, Float> pie = new HashMap<>();
        List<String> alerts = new ArrayList<>();

        List<Transaction> transactions = dataAccessObject.getAllEntries();

        // initalize to Day on first load
        if (selectedRange == null)
            selectedRange = "Day";
        if (selectedType == null)
            selectedType = "Expense";

        Date now = new Date();
        Calendar nowCal = Calendar.getInstance();
        nowCal.setTime(now);
        int nowYear = nowCal.get(Calendar.YEAR);
        int nowMonth = nowCal.get(Calendar.MONTH);

        // prefills the map with available dates
        if (selectedRange.equalsIgnoreCase("Day")) {
            int daysInMonth = nowCal.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int d = 1; d <= daysInMonth; d++) {
                bar.put(d, 0f);
            }
        } else if (selectedRange.equalsIgnoreCase("Month")) {
            for (int m = 1; m <= 12; m++) {
                bar.put(m, 0f);
            }
        } else { // Year
            int minYear = Integer.MAX_VALUE;
            for (Transaction t : transactions) {
                Date td = t.getDate();
                if (td == null)
                    continue;
                Calendar cc = Calendar.getInstance();
                cc.setTime(td);
                minYear = Math.min(minYear, cc.get(Calendar.YEAR));
            }
            if (minYear == Integer.MAX_VALUE)
                minYear = nowYear;
            for (int y = minYear; y <= nowYear; y++) {
                bar.put(y, 0f);
            }
        }

        for (Transaction transaction : transactions) {
            // skip transaction not of this type
            if (transaction.getType() != selectedType)
                return;
            Date t = transaction.getDate();
            Calendar c = Calendar.getInstance();
            c.setTime(t);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            List<Label> labels = transaction.getLabels();

            if (selectedRange.equals("Day")) {
                if (year == nowYear && month == nowMonth) {
                    bar.put(day, bar.get(day) + transaction.getAmount());
                    // add to pie

                }
            }

            else if (selectedRange.equals("Month")) {
                if (year == nowYear) {
                    bar.put(month, bar.get(month) + transaction.getAmount());
                }
            }

            else {
                bar.put(year, bar.get(year) + transaction.getAmount());
            }
        }
    }
}
