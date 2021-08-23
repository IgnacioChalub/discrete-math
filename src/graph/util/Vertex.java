package graph.util;


import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {

    private T element;
    private LinkedList<Vertex> ady;

    public Vertex(T element){
        this.element = element;
        this.ady = new LinkedList<>();
    }

    public void addAdy(Vertex v){
        ady.add(v);
    }

    public void removeAdy(Vertex v){
        ady.remove(v);
    }


    public T getElement() {
        return element;
    }

    public LinkedList<Vertex> getAdys() {
        return ady;
    }

    public void addEdge(Vertex v){
        ady.add(v);
    }

    public void removeEdge(Vertex vertexW) {
        ady.remove(vertexW);
    }
}
