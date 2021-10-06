package graph;

import graph.util.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// TODO: implement
public class AdjacencyListGraphImpl<T> implements Graph<T> {
    private int n;
    private int alpha;
    private ArrayList<Vertex> vertexList;

    public AdjacencyListGraphImpl(){
        this.n = 0;
        this.alpha = 0;
        this.vertexList = new ArrayList();
    }

    @Override
    public void addVertex(T x) {
        Vertex vertex = new Vertex(x);
        vertexList.add(vertex);
        n++;
    }

    @Override
    public boolean hasVertex(T v){
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getElement().equals(v)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeVertex(T x) {
            Vertex vertex = getVertex(x);
            LinkedList<Vertex> ady = vertex.getAdys();
            for (int i = 0; i < ady.size(); i++) {
                ady.get(i).removeAdy(vertex);
            }
            vertexList.remove(vertex);
            n--;
    }

    private Vertex<T> getVertex(T x) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getElement().equals(x)){
                return vertexList.get(i);
            }
        }
        return null;
    }

    private int getVertexIndex(T v){
        for (int i = 0; i < n; i++) {
            if (vertexList.get(i).getElement().equals(v)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addEdge(T v, T w) {
        if (hasVertex(v) && hasVertex(w)){
            Vertex vertexV = getVertex(v);
            Vertex vertexW = getVertex(w);
            vertexV.addEdge(vertexW);
            vertexW.addEdge(vertexV);
            alpha++;
        }
    }

    @Override
    public void removeEdge(T v, T w) {
        Vertex vertexV = getVertex(v);
        Vertex vertexW = getVertex(w);
        vertexV.removeEdge(vertexW);
        vertexW.removeEdge(vertexV);
        alpha--;
    }

    @Override
    public boolean hasEdge(T v, T w) {
        if (hasVertex(v) && hasVertex(w)){
            Vertex vertexV = getVertex(v);
            LinkedList<Vertex> adjacent = vertexV.getAdys();
            for (int i = 0; i < adjacent.size(); i++) {
                if (adjacent.get(i).getElement().equals(w)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int alpha() {
        return alpha;
    }

    @Override
    public List<T> getVertexes() {
        LinkedList<T> toReturn = new LinkedList<>();
        for (int i = 0; i < vertexList.size(); i++) {
            toReturn.add((T) vertexList.get(i).getElement());
        }
        return toReturn;
    }

    @Override
    public List<T> getAdjacencyList(T v) {
       int vIndex = getVertexIndex(v);
       if (vIndex == -1){
           throw new IllegalArgumentException("Vertex not found");
       }
       return vertexList.get(vIndex).getAdys();
    }

}
