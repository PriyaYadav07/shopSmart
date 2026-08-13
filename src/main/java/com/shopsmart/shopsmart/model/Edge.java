package com.shopsmart.shopsmart.model;

public class Edge {

    private final int destination;
    private final int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return destination + "(" + weight + ")";
    }


}