import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    // для каждого соседа (Vertex<V>) — вес ребра (Double)
    private Map<Vertex<V>, Double> adjacent = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }
    public void setData(V data) {
        this.data = data;
    }

    /** Добавить соседнюю вершину с указанным весом */
    public void addAdjacentVertex(Vertex<V> neighbor, double weight) {
        adjacent.put(neighbor, weight);
    }

    /** Нечего менять — возвращаем неизменяемую view для безопасности */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return Collections.unmodifiableMap(adjacent);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return data.equals(vertex.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
