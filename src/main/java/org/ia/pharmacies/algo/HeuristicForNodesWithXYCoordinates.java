package org.ia.pharmacies.algo;


import com.google.common.graph.EndpointPair;
import com.google.common.graph.ValueGraph;
import java.util.function.Function;

import org.ia.pharmacies.models.Pharmacie;


public class HeuristicForNodesWithXYCoordinates implements Function<Pharmacie, Double> {

  

  private final double maxSpeed;
  private final Pharmacie target;

  /**
   * Constructs the heuristic function for the specified graph and target node.
   *
   * @param graph the graph
   * @param target the target node
   */
  public HeuristicForNodesWithXYCoordinates(
      ValueGraph<Pharmacie, Double> graph, Pharmacie target) {
    // We need the maximum speed possible on any path in the graph for the heuristic function to
    // calculate the cost for a euclidean distance
    this.maxSpeed = calculateMaxSpeed(graph);
    this.target = target;
  }

  /**
   * Calculates the maximum speed possible on any path in the graph. The speed of a path is
   * calculated as: euclidean distance between the path's nodes, divided by its cost.
   *
   * @param graph the graph
   * @return the maximum speed
   */
  private static double calculateMaxSpeed(ValueGraph<Pharmacie, Double> graph) {
    return graph.edges().stream()
        .map(edge -> calculateSpeed(graph, edge))
        .max(Double::compare)
        .orElseThrow(() -> new IllegalArgumentException("Graph is empty"));
  }

  /**
   * Calculates the speed on a path in the graph. The speed of a path is calculated as: euclidean
   * distance between the path's nodes, divided by its cost.
   *
   * @param graph the graph
   * @param edge the edge (= path)
   * @return the speed
   */
  private static double calculateSpeed(
      ValueGraph<Pharmacie, Double> graph, EndpointPair<Pharmacie> edge) {
    double euclideanDistance = calculateEuclideanDistance(edge.nodeU(), edge.nodeV());
    double cost = graph.edgeValue(edge).orElseThrow(() -> new IllegalArgumentException("Graph is empty"));
    double speed = euclideanDistance / cost;

    return speed;
  }

  public static double calculateEuclideanDistance(Pharmacie source, Pharmacie target) {
    double distanceX = target.getX() - source.getX();
    double distanceY = target.getY() - source.getY();
    return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
  }

  /**
   * Applies the heuristic function to the specified node.
   *
   * @param node the node
   * @return the minimum cost for traveling from the specified node to the target
   */
  @Override
  public Double apply(Pharmacie node) {
    double euclideanDistance = calculateEuclideanDistance(node, target);
    double minimumCost = euclideanDistance / maxSpeed;

    return minimumCost;
  }
}