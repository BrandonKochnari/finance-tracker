package use_case.graph;

public class GraphInteractor implements GraphInputBoundary {
    private final GraphDataAccessInterface dataAccessObject;
    private final GraphOutputBoundary graphPresenter;
    public GraphInteractor(GraphDataAccessInterface dataAccessInterface, GraphOutputBoundary graphOutputBoundary){
        this.graphPresenter = graphOutputBoundary;
        this.dataAccessObject = dataAccessInterface;
    }

    @Override
    public void execute(GraphInputData graphInputData){
        //TODO: get data from database and display graph with the given data
    }
}
