// Graph is a collection of nodes and connections
// Vertex - Node
// Edge - Connections between nodes
// Weighted Graph - Connections between Nodes have values set to them
// Undirected Graph - Two way connections

// Adjacency Matrix- Takes up more space (in sparse graphs), slower to iterate over all edges. Faster to lookup specific edge
// Adjaceny List - Can take up less space in sparse graphs, faster to iterate over all edges, Slower to look up specific edge
class Vertex {
    String label;
    Vertex(String label) {
        this.label = label;
    }

    // equals and hashCode
}

class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;

    // standard constructor, getters, setters

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    //DFS Traversal Recursive
    public void dfs(int start) {
        boolean[] isVisited = new boolean[adjVertices.size()];
        List<Vertex> result = new ArrayList();
        dfsRecursive(start, isVisited);
    }

    private void dfsRecursive(int current, boolean[] isVisited, List<Integer> result) {
        if (!current) return null;
        isVisited[current] = true;
        result.add(current);
        for (int dest : adjVertices.get(current)) {
            if (!isVisited[dest])
                dfsRecursive(dest, isVisited);
        }
        return result;
    }
    // DFS Traversal Iterative
    Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    // BFS Traversal
    Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }

}


