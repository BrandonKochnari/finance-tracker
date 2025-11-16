package use_case.graph;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class GraphOutputData {
    private final String selectedRange;
    private final String selectedType;
    private final List<Long> x;
    private final List<Double> y;
    private final Map<String, Double> pie;
    private final List<String> alerts;

    public GraphOutputData(String selectedRange,
            String selectedType,
            List<Long> x,
            List<Double> y,
            Map<String, Double> pie,
            List<String> alerts) {
        this.selectedRange = selectedRange;
        this.selectedType = selectedType;
        if (x != null) {
            this.x = new ArrayList<>(x);
        }

        if (y != null) {
            this.y = new ArrayList<>(y);
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

    public List<Long> getX() {
        return Collections.unmodifiableList(x);
    }

    public List<Double> getY() {
        return Collections.unmodifiableList(y);
    }

    public Map<String, Double> getPie() {
        return Collections.unmodifiableMap(pie);
    }

    public List<String> getAlerts() {
        return Collections.unmodifiableList(alerts);
    }
}
