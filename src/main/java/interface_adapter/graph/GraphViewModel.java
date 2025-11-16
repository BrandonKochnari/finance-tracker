package interface_adapter;

import java.util.List;
import java.util.Map;
import interface_adapter.ViewModel;
import interface_adapter.GraphState;

public final class GraphViewModel extends ViewModel<GraphState> {
    public GraphViewModel() {
        super("Trend Graph");
        setState(new GraphState());
    }
}
