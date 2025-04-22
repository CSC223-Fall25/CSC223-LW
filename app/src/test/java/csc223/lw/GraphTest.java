package csc223.lw;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// import org.junit.jupiter.api.Test;
public class GraphTest {
    public static void main(String[] args) {
        // Unweighted Graph Tests
        UnweightedGraph unGraph = new UnweightedGraph();
        unGraph.addEdge(1, 2);
        unGraph.addEdge(2, 3);
        assertEquals(true, unGraph.hasEdge(1, 2));
        assertEquals(true, unGraph.hasEdge(2, 3));
        assertEquals(false, unGraph.hasEdge(1, 3));
        unGraph.addEdge(1, 3);
        assertEquals(true, unGraph.hasEdge(1, 3));
        unGraph.removeEdge(1, 2);
        assertEquals(true, unGraph.hasEdge(2, 3));
        assertEquals(true, unGraph.hasEdge(1, 3));
        assertEquals(false, unGraph.hasEdge(1, 2));
        unGraph.addEdge(1, 4);
        unGraph.addEdge(2, 5);
        unGraph.addEdge(3, 4);
        assertArrayEquals(new int[]{2}, unGraph.getNeighbors(5));
        assertEquals(5, unGraph.getNumVertices());
        assertEquals("3 - 2 - 5 weight: 2", unGraph.shortestPath(3, 5));
        assertEquals("4 - 1 weight: 1", unGraph.shortestPath(4, 1));
        assertEquals("2 - 3 - 4 weight: 2", unGraph.shortestPath(2, 4));


        // // Weighted Graph Tests
        // WeightedGraph weGraph = new WeightedGraph();
        // weGraph.addEdge(1, 2, 2);
        // weGraph.addEdge(2, 3, 3);
        // weGraph.addEdge(3, 4, 4);
        // assertEquals(2, weGraph.getEdgeWeight(1, 2));
        // assertEquals(2, weGraph.getEdgeWeight(2, 1));
        // assertEquals(3, weGraph.getEdgeWeight(2, 3));
        // assertEquals(4, weGraph.getEdgeWeight(3, 4));
        // assertEquals(-1, weGraph.getEdgeWeight(1, 3));
        // weGraph.removeEdge(2, 3);
        // weGraph.addEdge(3, 1, 1);
        // assertEquals(-1, weGraph.getEdgeWeight(2, 3));
        // assertEquals(1, weGraph.getEdgeWeight(1, 3));
        // int[] out1 = new int[2];
        // out1[0] = 2;
        // out1[1] = 3;
        // int[] out2 = new int[1];
        // out2[0] = 3;
        // assertEquals(out1, weGraph.getNeighbors(1));
        // assertEquals(out2, weGraph.getNeighbors(4));
        // assertEquals(4, weGraph.getNumVertices());
        // assertEquals("1 - 3 - 4 weight: 5", weGraph.shortestPath(1, 4));
        // assertEquals("2 - 1 - 3 - 4 weight: 7", weGraph.shortestPath(2, 4));
        // assertEquals("3 - 1 - 2 weight: 3", weGraph.shortestPath(3, 2));
    }
}
