package interface_adapter.graph;

import java.util.List;
import java.util.Map;
import interface_adapter.graph.ViewModel;
import interface_adapter.graph.GraphState;

public final class GraphViewModel extends ViewModel<GraphState> {
    public GraphViewModel() {
        super("Trend Graph");
        setState(new GraphState());
    }
}
