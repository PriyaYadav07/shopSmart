package com.shopsmart.shopsmart.algorithm;

import com.shopsmart.shopsmart.graph.Graph;
import com.shopsmart.shopsmart.model.Edge;
import com.shopsmart.shopsmart.model.NodeDistance;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Component
public class Dijkstra {

    public Result shortestPath(
            Graph graph,
            int source
    ) {

        int vertices = graph.getVertices();

        int[] distance =
                new int[vertices + 1];

        int[] parent =
                new int[vertices + 1];

        Arrays.fill(
                distance,
                Integer.MAX_VALUE
        );

        Arrays.fill(
                parent,
                -1
        );

        PriorityQueue<NodeDistance> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                Integer.compare(
                                        a.getDistance(),
                                        b.getDistance()
                                )
                );

        distance[source] = 0;

        pq.offer(
                new NodeDistance(
                        source,
                        0
                )
        );

        while (!pq.isEmpty()) {

            NodeDistance current =
                    pq.poll();

            int currentNode =
                    current.getNode();

            int currentDistance =
                    current.getDistance();

            if (currentDistance
                    > distance[currentNode]) {

                continue;
            }

            for (Edge edge :
                    graph.getNeighbors(
                            currentNode
                    )) {

                int neighbor =
                        edge.getDestination();

                int edgeWeight =
                        edge.getWeight();

                int newDistance =
                        currentDistance
                                + edgeWeight;

                if (newDistance
                        < distance[neighbor]) {

                    distance[neighbor] =
                            newDistance;

                    parent[neighbor] =
                            currentNode;

                    pq.offer(
                            new NodeDistance(
                                    neighbor,
                                    newDistance
                            )
                    );
                }
            }
        }

        return new Result(
                distance,
                parent
        );
    }


    public List<Integer> getPath(
            int source,
            int destination,
            int[] parent
    ) {

        List<Integer> path =
                new ArrayList<>();

        int current =
                destination;

        while (current != -1) {

            path.add(current);

            if (current == source) {
                break;
            }

            current =
                    parent[current];
        }

        if (path.isEmpty()
                || path.get(
                path.size() - 1
        ) != source) {

            return new ArrayList<>();
        }

        Collections.reverse(path);

        return path;
    }


    // Result class
    public static class Result {

        private final int[] distance;

        private final int[] parent;


        public Result(
                int[] distance,
                int[] parent
        ) {

            this.distance = distance;

            this.parent = parent;
        }


        public int[] getDistance() {
            return distance;
        }


        public int[] getParent() {
            return parent;
        }
    }
}