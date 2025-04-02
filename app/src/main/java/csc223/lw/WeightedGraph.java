package csc223.lw;

import java.util.Arrays;

public class WeightedGraph implements WeightedGraphInterface{

    double[][] matrix;
    int size;

    public WeightedGraph(int size){
        this.size = size;
        this.matrix = new double[size][size];
    }

    public void addEdge(int v1, int v2){
        this.matrix[v1][v2] = 1;
        this.matrix[v2][v1] = 1;
    }

    public void addEdge(int v1, int v2, double weight){
        this.matrix[v1][v2] = weight;
        this.matrix[v2][v1] = weight;
    }

    public double getEdgeWeight(int v1, int v2){
        if (this.matrix[v1][v2] == 0){
            return -1;
        }
        else{
            return this.matrix[v1][v2];
        }
    }

    public void removeEdge(int v1, int v2){
        this.matrix[v1][v2] = 0;
        this.matrix[v2][v1] = 0;
    }

    public boolean hasEdge(int v1, int v2){
        if (this.matrix[v1][v2] == 0){
            return false;
        }
        return true;
    }
    
    public int[] getNeighbors(int vertex){
        int[] neighbors = new int[this.size];
        int neighborSize = 0;
        int i = 0;
        while (i < this.size){
            if (this.matrix[vertex][i] != 0){
                neighbors[neighborSize] = i;
                neighborSize++;
            }
            i++;
        }
        return Arrays.copyOfRange(neighbors, 0, neighborSize);
    }
    
    public int getNumVertices(){
        return this.size;
    }
    
    public void printGraph(){
        System.out.print("   ");
        for(int i = 0; i < this.size; i++){
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < this.size; i++){
            System.out.print(i + "  ");
            for (int j = 0; j < this.size; j++){
                System.out.print((int)this.matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public String shortestPath(int startVertex, int endVertex){
        String result = "";
        boolean[] visited = new boolean[this.size];
        double[] distances = new double[this.size];
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(startVertex);
        while (!queue.isEmpty()){
            int curr = queue.dequeue();
            visited[curr] = true;
            int[] neighbors = getNeighbors(curr);
            for (int i = 0; i < neighbors.length; i++){
                if (visited[neighbors[i]] == false){
                    double distance = getEdgeWeight(curr, neighbors[i]) + distances[curr];
                    if (distances[neighbors[i]] == 0 || distance < distances[neighbors[i]]){
                        distances[neighbors[i]] = distance;
                        queue.enqueue(neighbors[i]);
                    }
                }
            }
        }
        double prevWeight = distances[distances.length-1];
        result += distances.length-1;
        for (int i = distances.length-2; i >= 0; i--){
            if (distances[i] < prevWeight){
                result = i + " - " + result;
                prevWeight = distances[i];
            }
        }
        return result + " weight: " + (int)distances[distances.length-1];
    }

    public static void main(String[] args){
        WeightedGraph g = new WeightedGraph(6);
        g.addEdge(0, 2, 5);
        g.addEdge(0, 1, 3);
        g.addEdge(1, 2, 7);
        g.addEdge(2, 3, 4);
        g.addEdge(2, 4, 6);
        g.addEdge(3, 1, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(5, 3, 3);
        g.printGraph();
        System.out.println(g.shortestPath(0, 5));
    }
}
