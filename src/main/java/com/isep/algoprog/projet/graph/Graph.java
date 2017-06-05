package com.isep.algoprog.projet.graph;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isep.algoprog.projet.data.Link;
import com.isep.algoprog.projet.data.Network;
import com.isep.algoprog.projet.data.Station;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guillaume on 29/05/2017.
 * algoprog-projet
 */
public class Graph {
	private Map<String, Node> nodes = new HashMap();
	private Network network = new Network();

	public Map<String, Node> getNodes() {
		return nodes;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public Network getNetwork() {

		return network;
	}

	public void build(String filename) throws IOException {
		byte[] data =  Files.readAllBytes(Paths.get(filename));

		ObjectMapper om = new ObjectMapper();
		// création de l'objet network a partir du json
		Network network = om.readValue(data, Network.class);
		setNetwork(network);
		addNodes(network);
		for (String name:network.getStops().keySet() ) {
			network.getStops().get(name).setName(name);
		}
	}

	private void addNodes(Network network) {
		// on crée tout les nodes en premier
		for (String key: network.getStops().keySet()) {
			Station station = network.getStops().get(key);
			Node source = new Node(key,station);
			nodes.put(key, source);
		}
		// puis on ajoute les edge en reprenant les références des nodes
		addEdges();
	}

	private void addEdges() {
		for (String key: nodes.keySet()) {
			Node source = nodes.get(key);
			// on parcours tout les link d'une station pour ajouter les edges au node
			for (Link link: source.getData().getLinks()) {
				Node dest = nodes.get(link.getStation_name());
				source.addEdge(new Edge(source, dest, link.getLine()));
			}
		}
	}
}
