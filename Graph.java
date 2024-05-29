import java.util.LinkedList;

public class Graph {
    private int ver;
    private LinkedList<Integer> adjList[];
    public Graph(int ver) {
        this.ver = ver;
        adjList = new LinkedList[ver];
        for (int i = 0; i < ver; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }
    public void printGraph() {
        for (int i = 0; i < ver; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer node : adjList[i]) {
                System.out.print(" -> " + node);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertex = 4;
        Graph graph = new Graph(vertex);
        for (int i = 0; i < vertex; i++) {
            for (int j = i + 1; j < vertex; j++) {
                graph.addEdge(i, j);
            }
        }
        graph.printGraph();
    }
}