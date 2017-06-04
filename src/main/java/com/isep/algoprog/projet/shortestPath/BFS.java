package com.isep.algoprog.projet.shortestPath;

import com.isep.algoprog.projet.graph.Edge;
import com.isep.algoprog.projet.graph.Graph;
import com.isep.algoprog.projet.graph.Node;

import java.util.*;

import static java.lang.Boolean.TRUE;

/**
 * Created by alizeefaytre on 31/05/2017.
 */
public class BFS {

	private Map<String, Boolean> marked;
	private Map<String, Node> previous;
	private Map<String, Double> distance;

	public Map<String, Double> getDistance() {
		return distance;
	}

	public BFS(Graph G, String firstStation) {
		Queue<String> queue = new LinkedList<>();

		marked = new HashMap<>();
		distance = new HashMap<>();
		previous = new HashMap<>();

		marked.put(firstStation, Boolean.TRUE);
		distance.put(firstStation, 0.0);
		queue.add(firstStation);

		while (!queue.isEmpty()) {
			String activeNode = queue.poll();
			Queue<String> neighbors = G.getNodes().get(activeNode).getNeighbors(); // on recupere le noeud correspondant à la station activeNode et on demande les voisins

			while (!neighbors.isEmpty()) {
				String neighbor = neighbors.poll();

				if (!marked.containsKey(neighbor)) {
					marked.put(neighbor, TRUE);
					previous.put(neighbor, G.getNodes().get(activeNode));
					// on recupère la distance entre les deux stations
					Double dist = 0.0;
					for (Edge edge : G.getNodes().get(activeNode).getEdges()) {
						String source = "";
						String dest = "";
						for (String key : G.getNodes().keySet()) {
							if (edge.getSource().equals(G.getNodes().get(key))) {
								source = key;
							}
							if (edge.getDest().equals(G.getNodes().get(key))) {
								dest = key;
							}
						}
						if (source.equals(activeNode) && dest.equals(neighbor)) {
							dist = edge.getDistance();
						}
					}
					distance.put(neighbor, distance.get(activeNode) + dist);
					queue.add(neighbor);
				}
			}
		}

	}

	public boolean hasPathTo(String station) {
		if (marked.containsKey(station)) {
			return true;
		}
		return false;
	}

	public List<String> printSP(String firstStation, String lastStation) {
		String prev = lastStation;
		List<String> stack = new ArrayList<>();
		List<Edge> edges = new ArrayList<>();
		stack.add(lastStation);
		while (!prev.equals(firstStation)) {
			if (previous.get(prev).findEdgeToStation(prev) != null) {
				edges.add(previous.get(prev).findEdgeToStation(prev));
			}
			prev = previous.get(prev).getStationName();
			stack.add(prev);
		}

		// Décommenter cette partie pour afficher dans la console le shortest path
		//  |
		//  v

		System.out.println("voici le SP avec BFS : ");
		for (int i = stack.size() - 1; i >= 0; i--) {
			if (stack.get(i).equals(lastStation)) {
				System.out.print(stack.get(i));
			} else {
				System.out.print(stack.get(i) + " - "+ edges.get(i - 1).getLine() + " -> ");
			}
		}
		return stack;
	}

}
