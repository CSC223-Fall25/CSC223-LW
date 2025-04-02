package csc223.lw;

/**
 * Class implementing an unweighted graph using an adjacency matrix.
 */
public class UnweightedGraph implements Graph {
    // Implement all methods from the Graph interface
    // Use BFS for the shortestPath method

    private int[][] matrix;
    private int size;

    public UnweightedGraph(int initialSize) {
        size = initialSize;
        matrix = new int[size][size];
    }

    private void resizeMatrix(int newSize) {
        int[][] newMatrix = new int[newSize][newSize];

        for (int i = 0; i < size; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, size);
        }

        matrix = newMatrix;
        size = newSize;
    }

    public void addEdge(int v1, int v2) {
        int maxIndex = Math.max(v1, v2);

        // If we need more space
        if (maxIndex >= size) {
            resizeMatrix(maxIndex + 1);
        }

        // Symmetrical for undirected
        matrix[v1][v2] = 1;
        matrix[v2][v1] = 1;
    }

    public void removeEdge(int v1, int v2) {

        if ((v1 >= size) || (v2 >= size) || (Math.min(v1, v2)<0)) {
            System.out.println("One or more vertices do not exist");
            return;
        }
        matrix[v1][v2] = 0;
        matrix[v2][v1] = 0;
    }

    public boolean hasEdge(int v1, int v2) {
        if ((v1 >= size) || (v2 >= size) || (Math.min(v1, v2)<0)) {
            System.out.println("One or more vertices do not exist");
            return false;
        }
        return matrix[v1][v2] == 1;
    }

    public int[] getNeighbors(int vertex) {
        if ((vertex >= size) || (vertex < 0)) {
            System.out.println("Vertex does not exist");
            return new int[0];
        }

        return matrix[vertex];
    }

    public int getNumVertices() {
        return size;
    }

    public void printGraph() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + "- ");
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public String shortestPath(int startVertex, int endVertex) {
        if ((startVertex >= size) || (endVertex >= size) || (startVertex < 0) || (endVertex < 0)) {
            return "One or more vertices do not exist";
        }

        boolean[] visited = new boolean[size];
        int[] parent = new int[size];
        ArrayQueue queue = new ArrayQueue();

        queue.enqueue(startVertex);
        visited[startVertex] = true;
        parent[startVertex] = -1;

        while (!queue.isEmpty()) {
            int curr = queue.dequeue();

            if (curr == endVertex) {
                break;
            }

            for (int i = 0; i < size; i++) {
                if (matrix[curr][i] == 1 && !visited[i]) {
                    queue.enqueue(i);
                    visited[i] = true;
                    parent[i] = curr;
                }
            }
        }

        if (!visited[endVertex]) {
            return "No path";
        }

        String shortestPath = Integer.toString(endVertex);
        for (int at = endVertex; at != -1; at = parent[at]) {
            shortestPath = Integer.toString(at) + "- " + shortestPath;
        }
        return shortestPath;
    }
}