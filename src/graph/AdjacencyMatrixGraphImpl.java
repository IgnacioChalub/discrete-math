package graph;

import java.util.LinkedList;
import java.util.List;

// TODO: implement
public class AdjacencyMatrixGraphImpl<T> implements Graph<T> {
    private T V[];
    private boolean[][] A;
    private int n;
    private int alpha;

    public AdjacencyMatrixGraphImpl(){
        this.V = (T[]) new Object[10];
        this.A = new boolean[10][10];
        this.n = 0;
        this.alpha = 0;

    }

    @Override
    public void addVertex(T x) {
        if (isFull()){
            expand();
        }
        V[n] = x;
        n++;
    }

    private boolean isFull(){
        return n == V.length;
    }

    private void expand(){ //duplica la capacidad
        T[] v2 = (T[]) new Object[V.length*2];
        for (int i = 0; i < V.length; i++) {
            v2[i] = V[i];
        }
        boolean[][] A2 = new boolean[v2.length][v2.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                A2[i][j] = A[i][j];
            }
        }
        V = v2;
        A = A2;

    }

    @Override
    public boolean hasVertex(T v) {
        return getIndex(v) != -1;
    }

    private int getIndex(T v){
        for (int i = 0; i < n; i++) {
            if (V[i].equals(v)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeVertex(T x) {
        int v = getIndex(x);

        //Lo elimina del arreglo y corriendo todos los que le sigan un lugar para la izq
        for (int i = v; i < n-1; i++) {
            V[i] = V[i+1];
        }

        //Corre todas las filas de la matriz que le sigan un lugar para arriba y las columnas uno para la izquierda
        //Filas para arriba:
        for (int i = v; i < n-1; i++) { //fila i
            for (int j = 0; j < n; j++) { //columna j
                A[i][j] = A[i+1][j];
            }
        }
        //Columnas para la izq
        for (int j = v; j < n-1; j++) {
            for (int i = 0; i < n; i++) {
                A[i][j] = A[i][j+1];
            }
        }

        //le resta 1 a n
        n--;
    }

    @Override
    public void addEdge(T v, T w) {
        int vIndex = getIndex(v);
        int wIndex = getIndex(w);
        if (vIndex != -1 && wIndex != -1){
            if (!A[vIndex][wIndex]){
                A[vIndex][wIndex]= true;
                A[wIndex][vIndex] = true;
                alpha++;
            }
        }
    }

    @Override
    public void removeEdge(T v, T w) {
        int vIndex = getIndex(v);
        int wIndex = getIndex(w);
        if (A[vIndex][wIndex]){
            A[vIndex][wIndex]=A[wIndex][vIndex] = false;
            alpha--;
        }
    }

    @Override
    public boolean hasEdge(T v, T w) {
        int vIndex = getIndex(v);
        int wIndex = getIndex(w);
        if (vIndex != -1 && wIndex != -1) {
            return A[vIndex][wIndex];
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
        LinkedList<T> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(V[i]);
        }
        return list;
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        LinkedList<T> list = new LinkedList();
        int vIndex = getIndex(v);
        for (int w = 0; w < n ; w++){
            if (A[vIndex][w]){
                list.add(V[w]);
            }
        }
        return list;
    }
}
