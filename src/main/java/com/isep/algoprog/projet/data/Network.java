package com.isep.algoprog.projet.data;

import com.isep.algoprog.projet.Cluster.Path;

import java.util.Map;

/**
 * Created by Guillaume on 25/05/2017.
 * algoprog-projet
 */
public class Network extends Path {
	private Map<String, Station> stops;

	public Map<String, Station> getStops() {
		return stops;
	}

	public void setStops(Map<String, Station> stops) {
		this.stops = stops;
	}

	@Override
	public String toString() {
		return "Network{" +
				"stops=" + stops +
				'}';
	}
}
