package use_case.graph;

/*
 * The input data for the graph use case
 */
public class GraphInputData {
    private final String lineGraphRange;
    private final String pieGraphRange;

    public GraphInputData(String lineGraphRange, String pieGraphRange) {
        this.lineGraphRange = lineGraphRange;
        this.pieGraphRange = pieGraphRange;
    }

    /*
     * getter for lineGraphRange
     */
    public String getLineRange() {
        return this.lineGraphRange;
    }

    /*
     * getter for pieGraphRange
     */
    public String getPieRange() {
        return this.pieGraphRange;
    }
}