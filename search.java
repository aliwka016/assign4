import java.util.List;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;

    public Search(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    /** Должен вернуть упорядоченный список вершин от start до goal (или пустой) */
    public abstract List<Vertex<V>> search(Vertex<V> start, Vertex<V> goal);
}
