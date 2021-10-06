package tp2;

import graph.Graph;
import graph.util.Vertex;

import java.util.*;

public class Tp2Impl<T> implements Tp2<T> {
    @Override
    public List<T> depth_first_search(Graph<T> graph) {
        List<T> processed = new LinkedList<>();
        Stack<T> stack = new Stack<>();
        List<T> vertexes = graph.getVertexes();
        stack.push(vertexes.get(0));
        while (!stack.empty()){
            T current = stack.pop();
            processed.add(current);
            List<T> ady = graph.getAdjacencyList(current);
            for (int i = 0; i < ady.size(); i++) {
                if (!processed.contains(ady.get(i)) && !stack.contains(ady.get(i))){
                    stack.push(ady.get(i));
                }
            }
        }
        return processed;
    }

    @Override
    public List<T> breadth_first_search(Graph<T> graph) {
        Queue<T> queue = new LinkedList();
        List<T> processed = new LinkedList<>();
        List<T> vertexes = graph.getVertexes();
        queue.add(vertexes.get(0));
        while (!queue.isEmpty()){
            T current = queue.remove();
            processed.add(current);
            List<T> ady = graph.getAdjacencyList(current);
            for (int i = 0; i < ady.size(); i++) {
                if (!processed.contains(ady.get(i)) && !queue.contains(ady.get(i))){
                    queue.add(ady.get(i));
                }
            }
        }
        return processed;
    }

    @Override
    public boolean exercise_a(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_b(Graph<T> graph, T v) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_c(Graph<T> graph) {
        int n = graph.order();
        int alpha = graph.alpha();
        if (n == 0) return false;
        return n < alpha+1;
    }

    @Override
    public boolean exercise_d(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_e(Graph<T> graph, T v, T w) {
        List<T> visited = new LinkedList<>();
        return lengthOfPath(graph, v, w, visited, 0);
    }

    private int lengthOfPath(Graph graph, T v, T w, List<T> visited, int length){
        if (v.equals(w)) return length;
        visited.add(v);
        List<T> ady = graph.getAdjacencyList(v);
        if (ady.isEmpty()) return -1;
        for (int i = 0; i < ady.size(); i++) {
            if (!visited.contains(ady.get(i))){
                int path = lengthOfPath(graph, ady.get(i), w, visited, length+1);
                if (path >= 0) {
                    return path;
                }
            }
        }
        return -1;
    }

    @Override
    public List<T> exercise_f(Graph<T> graph,T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_g(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_h(Graph<T> graph) {
       List<T> vertexes = graph.getVertexes();
       List<T> processed = new LinkedList<>();
       int comp = 0;
       while (processed.size() < vertexes.size()){
           for (int i = 0; i < vertexes.size(); i++) {
               if (!processed.contains(vertexes.get(i))){
                   comp++;
                   hAux(processed, vertexes.get(i),graph);
               }
           }
       }
       return comp;
    }

    private void hAux(List<T> processed, T v, Graph<T> graph){
        Stack<T> stack = new Stack<>();
        stack.push(v);
        while (!stack.empty()){
            T current = stack.pop();
            processed.add(current);
            List<T> ady = graph.getAdjacencyList(current);
            for (int i = 0; i < ady.size(); i++) {
                if (!processed.contains(ady.get(i)) && !stack.contains(ady.get(i))){
                    stack.push(ady.get(i));
                }
            }
        }
    }

    @Override
    public boolean exercise_i(Graph<T> g1, Graph<T> g2) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_j(Graph<T> g1, Graph<T> g2) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_k(Graph<T> g1) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Graph<T> exercise_l(Graph<T> graph) {
        List<T> vertexes = graph.getVertexes();
        for (int i = 0; i < graph.order(); i++) {
            for (int j = i+1; j < graph.order(); j++) {
                T v = vertexes.get(i);
                T w = vertexes.get(j);
                if (graph.hasEdge(v, w)){
                    graph.removeEdge(v, w);
                } else {
                    graph.addEdge(v, w);
                }
            }
        }
        return graph;
    }

    @Override
    public int exercise_m(Graph<T> graph, T v) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Map<T, Integer> exercise_n(Graph<T> graph) {
        Map<T, Integer> map = new HashMap<>();
        List<T> vertexes = graph.getVertexes();
        for (int i = 0; i < vertexes.size(); i++) {
            int ady = 0; //la cantidad de adyacentes
            for (int j = 0; j < vertexes.size(); j++) {
                if (graph.hasEdge(vertexes.get(i), vertexes.get(j))){
                    if (i == j) ady++; //porque los lazos suman doble
                    ady++;
                }
            }
            map.put(vertexes.get(i), ady);
        }
        return map;
    }

}
