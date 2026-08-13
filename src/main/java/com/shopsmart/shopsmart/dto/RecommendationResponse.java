package com.shopsmart.shopsmart.dto;

import java.util.List;

public class RecommendationResponse {

    private int mallId;
    private String mallName;
    private int budget;
    private int crowdDensity;
    private int distance;
    private List<Integer> path;

    public RecommendationResponse() {
    }

    public RecommendationResponse(
            int mallId,
            String mallName,
            int budget,
            int crowdDensity,
            int distance,
            List<Integer> path
    ) {
        this.mallId = mallId;
        this.mallName = mallName;
        this.budget = budget;
        this.crowdDensity = crowdDensity;
        this.distance = distance;
        this.path = path;
    }

    public int getMallId() {
        return mallId;
    }

    public void setMallId(int mallId) {
        this.mallId = mallId;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getCrowdDensity() {
        return crowdDensity;
    }

    public void setCrowdDensity(int crowdDensity) {
        this.crowdDensity = crowdDensity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<Integer> getPath() {
        return path;
    }

    public void setPath(List<Integer> path) {
        this.path = path;
    }
}
