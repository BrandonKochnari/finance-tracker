package interface_adapter;

import use_case.graph.GraphOutputBoundary;
import use_case.graph.GraphOutputData;

public class GraphPresenter implements GraphOutputBoundary {
    private final GraphViewModel gvm;

    public GraphPresenter(GraphViewModel gvm) {
        this.gvm = gvm;
    }

    @Override
    public void prepareGraph(GraphOutputData data) {
        final GraphState graphState = gvm.getState();

        // update change for every attribute in data unless its null
        if (data.getSelectedRange() != null)
            graphState.setSelectedRange(data.getSelectedRange());

    }

    @Override
    public void prepareAlert(GraphOutputData data) {

    }
}