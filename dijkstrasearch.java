import java.util.*;

public class DijkstraSearch<V> extends Search<V> {

    public DijkstraSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public List<Vertex<V>> search(Vertex<V> start, Vertex<V> goal) {
        Map<Vertex<V>, Double> dist = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> prev = new HashMap<>();
        for (Vertex<V> v : graph.getVertices()) {
            dist.put(v, Double.POSITIVE_INFINITY);
        }
        dist.put(start, 0.0);

        // компаратор смотрит на текущее dist
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparing(dist::get));
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> u = pq.poll();
            if (u.equals(goal)) break;

            for (Map.Entry<Vertex<V>, Double> e : u.getAdjacentVertices().entrySet()) {
                Vertex<V> v = e.getKey();
                double weight = e.getValue();
                double alt = dist.get(u) + weight;
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                    // обновляем очередь
                    pq.remove(v);
                    pq.add(v);
                }
            }
        }

        // восстановление пути
        List<Vertex<V>> path = new ArrayList<>();
        if (!prev.containsKey(goal) && !start.equals(goal)) {
            return path; // нет пути
        }

        Vertex<V> step = goal;
        path.add(step);
        while (!step.equals(start)) {
            step = prev.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
}
