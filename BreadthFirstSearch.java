import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public List<Vertex<V>> search(Vertex<V> start, Vertex<V> goal) {
        Queue<Vertex<V>> queue = new ArrayDeque<>();
        Map<Vertex<V>, Vertex<V>> parent = new HashMap<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> cur = queue.poll();
            if (cur.equals(goal)) break;

            for (Vertex<V> nbr : cur.getAdjacentVertices().keySet()) {
                if (!visited.contains(nbr)) {
                    visited.add(nbr);
                    parent.put(nbr, cur);
                    queue.add(nbr);
                }
            }
        }

        // восстановление пути
        List<Vertex<V>> path = new ArrayList<>();
        if (!parent.containsKey(goal) && !start.equals(goal)) {
            return path; // путь не найден
        }

        Vertex<V> step = goal;
        path.add(step);
        while (!step.equals(start)) {
            step = parent.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
}
