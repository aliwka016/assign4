import java.util.List;

public class Main {
    public static void main(String[] args) {
        // --- Строим граф
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> astana        = new Vertex<>("Astana");
        Vertex<String> karaganda     = new Vertex<>("Karaganda");
        Vertex<String> balkash       = new Vertex<>("Balkash");
        Vertex<String> almaty        = new Vertex<>("Almaty");
        Vertex<String> pavlodar      = new Vertex<>("Pavlodar");
        Vertex<String> semey         = new Vertex<>("Semey");
        Vertex<String> taldykorgan   = new Vertex<>("Taldykorgan");
        Vertex<String> kokshetau     = new Vertex<>("Kokshetau");
        Vertex<String> taraz         = new Vertex<>("Taraz");

        // Добавляем ребра (неориентированно, вес = 1.0 по умолчанию)
        graph.addEdge(astana, karaganda);
        graph.addEdge(karaganda, balkash);
        graph.addEdge(balkash, almaty);
        graph.addEdge(balkash, taraz);
        graph.addEdge(almaty, taraz);
        graph.addEdge(almaty, taldykorgan);
        graph.addEdge(taldykorgan, semey);
        graph.addEdge(astana, pavlodar);
        graph.addEdge(pavlodar, semey);
        graph.addEdge(astana, kokshetau);

        // --- Печатаем список смежности
        System.out.println("Граф (список смежности):");
        for (Vertex<String> v : graph.getVertices()) {
            System.out.print(v + " -> ");
            v.getAdjacentVertices().keySet()
                    .forEach(nbr -> System.out.print(nbr + " "));
            System.out.println();
        }


        // --- Демонстрируем BFS
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        List<Vertex<String>> bfsPath = bfs.search(astana, semey);
        System.out.println("\nBFS путь Astana → Semey: " + bfsPath);

        // --- Демонстрируем Dijkstra
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        List<Vertex<String>> djPath = dijkstra.search(astana, semey);
        System.out.println("Dijkstra путь Astana → Semey: " + djPath);
    }
}
