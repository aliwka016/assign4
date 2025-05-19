import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices = new HashSet<>();
    private boolean directed;

    public WeightedGraph() {
        this(false);
    }

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public void addVertex(Vertex<V> v) {
        vertices.add(v);
    }

    /** Добавить ориентированное ребро u→v с весом w */
    public void addEdge(Vertex<V> u, Vertex<V> v, double w) {
        addVertex(u);
        addVertex(v);
        u.addAdjacentVertex(v, w);
        if (!directed) {
            v.addAdjacentVertex(u, w);
        }
    }

    /** Для обратной совместимости: ребро без указания веса = 1.0 */
    public void addEdge(Vertex<V> u, Vertex<V> v) {
        addEdge(u, v, 1.0);
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
