package com.isep.algoprog.projet.graph;

import com.isep.algoprog.projet.data.Location;

/**
 * Created by Guillaume on 29/05/2017.
 * algoprog-projet
 */
public class Edge {
	private Node source;
	private Node dest;
	private String line;
	private double distance;

	public Edge(Node source, Node dest, String line) {
		this.source = source;
		this.dest = dest;
		this.line = line;
		this.distance = computeDistance(); // en metres
	}

	public Node getSource() {
		return source;
	}

	public Node getDest() {
		return dest;
	}

	public String getLine() {
		return line;
	}

	public double getDistance() {
		return distance;
	}

	private double computeDistance() {
		Location l1 = source.getData().getLocation();
		Location l2 = dest.getData().getLocation();

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(l2.getLatitude() - l1.getLatitude());
		double lonDistance = Math.toRadians(l2.getLongitude() - l1.getLongitude());

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(l1.getLatitude())) * Math.cos(Math.toRadians(l2.getLatitude()))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return R * c * 1000;
	}

}
