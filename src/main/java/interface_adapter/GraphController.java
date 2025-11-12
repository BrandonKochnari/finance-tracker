package interface_adapter;
import use_case.graph.GraphInputBoundary;
import use_case.graph.GraphInputData;

public class GraphController {
    private final GraphInputBoundary graphUseCaseInteractor;

    public GraphController(GraphInputBoundary graphInputBoundary){
        this.graphUseCaseInteractor = graphInputBoundary;
    }

    /*
     * Executes the graph use case
     */
    public void execute(String lineGraphRange, String pieGraphRange){
        final GraphInputData graphInputData = new GraphInputData(
            lineGraphRange,
            pieGraphRange
        );

        this.graphUseCaseInteractor.execute(graphInputData);
    }
}
