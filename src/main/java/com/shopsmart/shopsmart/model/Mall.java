package com.shopsmart.shopsmart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "malls")
public class Mall {

    @Id
    private int id;

    private String name;

    private int budget;

    private int crowdDensity;

    public Mall() {
    }

    public Mall(
            int id,
            String name,
            int budget,
            int crowdDensity
    ) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.crowdDensity = crowdDensity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}