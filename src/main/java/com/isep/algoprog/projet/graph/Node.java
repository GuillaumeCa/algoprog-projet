package com.isep.algoprog.projet.graph;

import com.isep.algoprog.projet.data.Station;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Guillaume on 29/05/2017.
 * algoprog-projet
 */
public class Node {

	private String stationName;
	private Station data;
	private List<String> lines;
	private List<Edge> edges = new ArrayList<>();

	public Node(String name, Station data) {
		this.data = data;
		this.stationName = name;
		this.lines = data.getLines();
	}

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public Station getData() {
		return data;
	}

	public Queue<String> getNeighbors(){
		Queue<String> neighbors = new LinkedList<>();
		for (Edge edge: edges) {
			neighbors.add(edge.getDest().getStationName());
		}
		return neighbors;
	}

	public Edge findEdgeToStation(String name) {
		for (Edge edge: edges) {
			if (edge.getDest().getStationName().equals(name)) {
				return edge;
			}
		}
		return null;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public List<String> getLines() {
		return lines;
	}
}
