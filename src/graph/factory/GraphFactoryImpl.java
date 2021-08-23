package graph.factory;

import graph.*;

public class GraphFactoryImpl<T> implements GraphFactory<T> {
    @Override
    public Graph<T> createFromType(GraphType type) {
        Graph<T> graph = null;
        switch (type) {
            case ADJACENCY_MATRIX:
                graph = new AdjacencyMatrixGraphImpl<>();
                break;
            case ADJACENCY_LIST:
                graph = new AdjacencyListGraphImpl<>();
                break;
            case EDGE_ARRAY:
                graph = new EdgeArrayGraphImpl<>();
                break;
        }
        return graph;
    }

    //    Returns a random graph
    @Override
    public Graph<T> getGraph() {
//        return new EdgeArrayGraphImpl<>();
       return new AdjacencyMatrixGraphImpl<>();
//        return new AdjacencyListGraphImpl<>();
       // throw new UnsupportedOperationException("TODO: replace with one graph");
    }
}
