package com.isep.algoprog.projet.graph;

import com.isep.algoprog.projet.data.Link;
import com.isep.algoprog.projet.data.Station;

import java.util.*;

/**
 * Created by Guillaume on 29/05/2017.
 * algoprog-projet
 */
public class Node {
	private Station data;
	private List<String> lines;
	private List<Edge> edges = new ArrayList();

	public Node(Station data) {
		this.data = data;
		this.lines = data.getLines();
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public Station getData() {
		return data;
	}

	public Queue<String> getNeighbors(){
		Queue<String> neighbors = new LinkedList<String>();
		for (Link link:data.getLinks()) {
			neighbors.add(link.getStation_name());
		}
		return neighbors;
	}
}
