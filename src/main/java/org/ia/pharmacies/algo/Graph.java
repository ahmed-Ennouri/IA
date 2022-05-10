package org.ia.pharmacies.algo;

import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.ia.pharmacies.models.Pharmacie;

public class Graph {
	 
	private MutableValueGraph<Pharmacie, Double> graph;
	private Map<String, Pharmacie> pharmacies;
	private String pharmacieFile;
	private String cout;
	
	public Graph() {
		ValueGraph<Pharmacie, Double> graph = createSampleGraph();
		Map<String, Pharmacie> nodeByName = createNodeByNameMap(graph);
//		findAndPrintShortestPath(graph, nodeByName.get("D"), nodeByName.get("H"));
		
	}

	public ValueGraph<Pharmacie, Double> createSampleGraph() {
		MutableValueGraph<Pharmacie, Double> graph = ValueGraphBuilder.undirected().build();
		getPharmacies();
		getEdgeValue();

		return graph;
	}
	
	
	
	public void getPharmacies() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(source));
			String row = in.readLine();
			while (row != null) {
				String t[] = row.split(";");
				builder.buildPart2(t);
				builder.buildPart3(filter);
				row = in.readLine();
			}
			in.close();
			builder.buildPart4();
			return builder.getResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
		
		Pharmacie a = new Pharmacie("A", 2_410, 6_230);
	}
	
	
	public void getEdgeValue() {
		graph.putEdgeValue(a, c, 2.0);
	}

	
	
	
	public Map<String, Pharmacie> createNodeByNameMap() {
		return graph.nodes().stream().collect(Collectors.toMap(Pharmacie::getName, Function.identity()));
	}

	public void findAndPrintShortestPath(Pharmacie source,Pharmacie target) {
		Function<Pharmacie, Double> heuristic = new HeuristicForNodesWithXYCoordinates(graph, target);
		List<Pharmacie> shortestPath = AStarWithTreeSet.findShortestPath(graph, source, target, heuristic);
		System.out.println("shortestPath from {} to {} = {}" + source + target + shortestPath);
	}
}
