package com.shopsmart.shopsmart.graph;

import com.shopsmart.shopsmart.model.Edge;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final int vertices;

    private final List<List<Edge>> adjacencyList;

    public Graph(int vertices) {

        this.vertices = vertices;

        adjacencyList = new ArrayList<>();

        for (int i = 0; i <= vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(
            int source,
            int destination,
            int weight
    ) {

        adjacencyList
                .get(source)
                .add(
                        new Edge(
                                destination,
                                weight
                        )
                );

        adjacencyList
                .get(destination)
                .add(
                        new Edge(
                                source,
                                weight
                        )
                );
    }

    public List<Edge> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    public int getVertices() {
        return vertices;
    }

    public void printGraph() {

        for (int i = 1; i <= vertices; i++) {

            System.out.print(i + " -> ");

            for (Edge edge :
                    adjacencyList.get(i)) {

                System.out.print(edge + " ");
            }

            System.out.println();
        }
    }
}