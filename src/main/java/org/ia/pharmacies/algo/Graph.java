package org.ia.pharmacies.algo;

import com.google.common.graph.MutableValueGraph;
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
	
	public Graph() {
		graph = createSampleGraph();
		pharmacies = createNodeByNameMap();	
		
		addPharmacies();
		addEdgeValue();
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.findAndPrintShortestPath("Pharmacie ILYA", "Pharmacie Ravin");

		
	}
	public Map<String, Pharmacie> getPharmacies() {
		return pharmacies;
	}
	
	public MutableValueGraph<Pharmacie, Double> createSampleGraph() {
		MutableValueGraph<Pharmacie, Double> graph = ValueGraphBuilder.undirected().build();
		return graph;
	}
	
	public Map<String, Pharmacie> createNodeByNameMap() {
		return graph.nodes().stream().collect(Collectors.toMap(Pharmacie::getName, Function.identity()));
	}

	public List<Pharmacie> findAndPrintShortestPath(String s,String t) {
		Pharmacie  source =pharmacies.get(s);
		Pharmacie  target =pharmacies.get(t);
		Function<Pharmacie, Double> heuristic = new HeuristicForNodesWithXYCoordinates(graph, target);
		List<Pharmacie> shortestPath = AStarWithTreeSet.findShortestPath(graph, source, target, heuristic);
		System.out.println("shortestPath from: "+ source  +" to: " + target + "=>  " + shortestPath);
		return shortestPath;
	}
	
	
	
	public void addPharmacies() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Ahmed\\OneDrive\\Bureau\\IA\\Project-IA\\src\\main\\webapp\\WEB-INF\\resources\\pharmacies.txt"));
			String row = in.readLine();
			while (row != null) {
				String t[] = row.split(";");
				Pharmacie a = new Pharmacie(t[0], Double.parseDouble(t[1]), Double.parseDouble(t[2]));
				pharmacies.put(t[0], a);
				row = in.readLine();
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

	
	public void addEdgeValue() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Ahmed\\OneDrive\\Bureau\\IA\\Project-IA\\src\\main\\webapp\\WEB-INF\\resources\\cost.txt"));
			String row = in.readLine();
			while (row != null) {
				String t[] = row.split(";");
				graph.putEdgeValue(pharmacies.get(t[0]),pharmacies.get(t[1]), Double.parseDouble(t[2]));
				row = in.readLine();
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

}
