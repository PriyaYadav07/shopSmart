package com.shopsmart.shopsmart.algorithm;

public class Result {

    private final int[] distance;
    private final int[] parent;

    public Result(int[] distance, int[] parent) {
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
