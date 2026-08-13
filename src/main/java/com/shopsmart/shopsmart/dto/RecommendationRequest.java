package com.shopsmart.shopsmart.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RecommendationRequest {

    @NotNull
    @Min(1)
    private Integer source;

    @NotNull
    @Min(0)
    private Integer budget;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer crowdPreference;

    public RecommendationRequest() {
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getCrowdPreference() {
        return crowdPreference;
    }

    public void setCrowdPreference(
            Integer crowdPreference
    ) {
        this.crowdPreference =
                crowdPreference;
    }
}