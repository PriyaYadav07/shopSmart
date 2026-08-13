package com.shopsmart.shopsmart.controller;

import com.shopsmart.shopsmart.dto.RecommendationRequest;
import com.shopsmart.shopsmart.dto.RecommendationResponse;
import com.shopsmart.shopsmart.service.RecommendationService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(
            RecommendationService recommendationService
    ) {
        this.recommendationService =
                recommendationService;
    }

    @PostMapping
    public List<RecommendationResponse> getRecommendations(
            @Valid @RequestBody RecommendationRequest request
    ) {

        return recommendationService.recommend(
                request.getSource(),
                request.getBudget(),
                request.getCrowdPreference()
        );
    }
}