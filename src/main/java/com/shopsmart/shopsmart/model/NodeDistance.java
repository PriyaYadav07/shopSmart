package com.shopsmart.shopsmart.model;

public class NodeDistance {

    private final int node;
    private final int distance;

    public NodeDistance(
            int node,
            int distance
    ) {
        this.node = node;
        this.distance = distance;
    }

    public int getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }
}