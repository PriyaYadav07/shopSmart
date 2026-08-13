package com.shopsmart.shopsmart.service;

import com.shopsmart.shopsmart.algorithm.Dijkstra;
import com.shopsmart.shopsmart.algorithm.Dijkstra.Result;
import com.shopsmart.shopsmart.dto.RecommendationResponse;
import com.shopsmart.shopsmart.graph.Graph;
import com.shopsmart.shopsmart.model.Mall;
import com.shopsmart.shopsmart.repository.MallRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {

    private final MallRepository mallRepository;
    private final Dijkstra dijkstra;

    private Graph graph;
    private List<Mall> malls;

    public RecommendationService(
            MallRepository mallRepository,
            Dijkstra dijkstra
    ) {
        this.mallRepository = mallRepository;
        this.dijkstra = dijkstra;
    }

    @PostConstruct
    public void loadData() {

        malls = mallRepository.findAll();

        // Create graph
        graph = new Graph(5);

        // Add roads between locations
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 4, 20);
        graph.addEdge(3, 4, 10);
        graph.addEdge(3, 5, 25);
        graph.addEdge(4, 5, 10);

        System.out.println("Total malls = " + malls.size());

        for (Mall mall : malls) {
            System.out.println(
                    "Mall ID = " + mall.getId()
                            + ", Name = " + mall.getName()
                            + ", Budget = " + mall.getBudget()
                            + ", Crowd = " + mall.getCrowdDensity()
            );
        }
    }

    public List<RecommendationResponse> recommend(
            Integer source,
            Integer budget,
            Integer crowdPreference
    ) {

        List<RecommendationResponse> recommendations =
                new ArrayList<>();

        Result result =
                dijkstra.shortestPath(
                        graph,
                        source
                );

        int[] distances =
                result.getDistance();

        int[] parents =
                result.getParent();

        for (Mall mall : malls) {

            // Filter according to user's preferences
            if (mall.getBudget() <= budget
                    && mall.getCrowdDensity()
                    <= crowdPreference) {

                int mallId = mall.getId();

                int distance = distances[mallId];

                // Skip unreachable malls
                if (distance == Integer.MAX_VALUE) {
                    continue;
                }

                List<Integer> path =
                        dijkstra.getPath(
                                source,
                                mallId,
                                parents
                        );

                RecommendationResponse response =
                        new RecommendationResponse(
                                mall.getId(),
                                mall.getName(),
                                mall.getBudget(),
                                mall.getCrowdDensity(),
                                distance,
                                path
                        );

                recommendations.add(response);
            }
        }

        // Nearest mall first
        recommendations.sort(
                (a, b) ->
                        Integer.compare(
                                a.getDistance(),
                                b.getDistance()
                        )
        );

        return recommendations;
    }

    public List<Mall> getMalls() {
        return malls;
    }
}