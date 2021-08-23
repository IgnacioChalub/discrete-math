package tp1;

import graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// TODO: implement
public class Tp1Impl<T> implements Tp1<T> {
    @Override
    public void exercise_a(Graph<T> graph) {
        LinkedList<T> vertexes = (LinkedList<T>) graph.getVertexes();
        String vString = "V = {";
        for (int i = 0; i < graph.order()-1; i++) {
            vString += vertexes.get(i) + "; ";
        }
        if (vertexes.size()-1 > 0)
            vString += vertexes.get(vertexes.size()-1);
        vString += "}";

        String aString = "A = {";
        for (int i = 0; i < graph.order()-1; i++) {
            for (int j = i; j < graph.order(); j++) {
                if (graph.hasEdge(vertexes.get(i), vertexes.get(j))){
                    aString += "{" + vertexes.get(i) + ", " + vertexes.get(j) + "}, ";
                }
            }
        }
        if (aString.length() > 5)
            aString = aString.substring(0, aString.length()-2);
        aString += "}";

        System.out.println("G = (V, A)");
        System.out.println(vString);
        System.out.println(aString);

    }

    @Override
    public int exercise_b(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_c(Graph<T> graph) {
        LinkedList<T> vertexes = (LinkedList<T>) graph.getVertexes();
        LinkedList<T> lazos = new LinkedList<>();
        for (int i = 0; i < vertexes.size(); i++) {
            T vertex = vertexes.get(i);
            if (graph.hasEdge(vertex, vertex)){
                lazos.add(vertex);
            }
        }
        return lazos;
    }

    @Override
    public boolean exercise_d(Graph<T> graph, T vertex) {
        List<T> list = graph.getAdjacencyList(vertex);
        return list.size() == 0;
    }

    @Override
    public int exercise_e(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_f(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Graph<T> exercise_g(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int[][] exercise_h(Graph<T> graph) {
        int n = graph.order();
        int[][] matrix = new int[n][n];

        LinkedList<T> vertexes = (LinkedList<T>) graph.getVertexes();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (graph.hasEdge(vertexes.get(i), vertexes.get(j))){
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                }
            }
        }

        //PRINT
        for (int i = 0; i < n; i++) {
            String row = "( ";
            for (int j = 0; j < n; j++) {
                row += matrix[i][j] + " ";
            }
            row += ")";
            System.out.println(row);
        }
        System.out.println("");

        return matrix;
    }

    @Override
    public int[][] exercise_i(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }
}
