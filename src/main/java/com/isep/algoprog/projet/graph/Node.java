package com.isep.algoprog.projet.graph;

import com.isep.algoprog.projet.data.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillaume on 29/05/2017.
 * algoprog-projet
 */
public class Node {
	private Station data;
	private List<String> lines;
	private List<Edge> edges = new ArrayList<>();

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
}
