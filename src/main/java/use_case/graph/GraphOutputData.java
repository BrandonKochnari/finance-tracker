package use_case.graph;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class GraphOutputData {
    private String selectedRange;
    private String selectedType;
    private Map<Integer, Float> bar;
    private Map<String, Double> pie;
    private List<String> alerts;

    public GraphOutputData(String selectedRange,
            String selectedType,
            List<Integer> x,
            List<Float> y,
            Map<String, Double> pie,
            List<String> alerts) {
        this.selectedRange = selectedRange;
        this.selectedType = selectedType;

        // build the bar map from parallel x and y lists if provided
        this.bar = new HashMap<>();
        if (x != null && y != null) {
            int n = Math.min(x.size(), y.size());
            for (int i = 0; i < n; i++) {
                Integer key = x.get(i);
                Float val = y.get(i);
                if (key != null && val != null) {
                    this.bar.put(key, val);
                }
            }
        }

        if (pie != null) {
            this.pie = new HashMap<>(pie);
        }

        if (alerts != null) {
            this.alerts = new ArrayList<>(alerts);
        }

    }

    public String getSelectedRange() {
        return selectedRange;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public List<Integer> getX() {
        if (bar == null)
            return null;
        return new ArrayList<>(bar.keySet());
    }

    public List<Float> getY() {
        if (bar == null)
            return null;
        return new ArrayList<>(bar.values());
    }

    public Map<String, Double> getPie() {
        return pie;
    }

    public Map<Integer, Float> getBar() {
        return bar;
    }

    public List<String> getAlerts() {
        return alerts;
    }
}
