package interface_adapter;

import java.util.List;
import java.util.Map;

/**
 * the state for the graph view model
 */
public class GraphState {
    private String selectedRange; // "Day" / "Month" / "Year"
    private String selectedType; // "Expense" / "Income"
    private List<Long> x; // indices or epoch millis
    private List<Double> y; // y values for the line/bar chart
    private Map<String, Double> pie; // category -> value

    public String getSelectedRange() {
        return selectedRange;
    }

    public void setSelectedRange(String selectedRange) {
        this.selectedRange = selectedRange;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }

    public List<Long> getX() {
        return x;
    }

    public void setX(List<Long> x) {
        this.x = x;
    }

    public List<Double> getY() {
        return y;
    }

    public void setY(List<Double> y) {
        this.y = y;
    }

    public Map<String, Double> getPie() {
        return pie;
    }

    public void setPie(Map<String, Double> pie) {
        this.pie = pie;
    }
}
}
