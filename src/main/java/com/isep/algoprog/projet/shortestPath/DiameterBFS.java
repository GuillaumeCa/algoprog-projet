package com.isep.algoprog.projet.shortestPath;

import com.isep.algoprog.projet.graph.Graph;
import com.isep.algoprog.projet.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alizeefaytre on 31/05/2017.
 */
public class DiameterBFS {

	public DiameterBFS(Graph G) {
		Map<List<String>, Double> spList = new HashMap<>();
		for (String node : G.getNodes().keySet()) {
			BFS bfs = new BFS(G, node);
			for (String secondNode : G.getNodes().keySet()) {
				if (!node.equals(secondNode)) {
					spList.put(bfs.printSP(node, secondNode), bfs.getDistance().get(secondNode));
				}
			}
		}

		Double lgPath = 0.0;
		List<String> key = new ArrayList<>();
		for (List<String> distance : spList.keySet()) {
			if (spList.get(distance) > lgPath) {
				lgPath = spList.get(distance);
				key = distance;
			}
		}

		System.out.println(" ");
		System.out.println("le diametre du graph avec BFS est : " + spList.get(key));
		System.out.println("et le shortest path correspondant est : ");
		for (String s : key) {
			System.out.print(s + " || ");
		}
	}
}
