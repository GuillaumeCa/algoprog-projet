package com.isep.algoprog.projet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isep.algoprog.projet.data.Network;
import com.isep.algoprog.projet.data.Station;
import com.isep.algoprog.projet.graph.Graph;
import com.isep.algoprog.projet.shortestPath.BFS;
import com.isep.algoprog.projet.shortestPath.DiameterBFS;
import com.isep.algoprog.projet.shortestPath.DiameterDijkstra;
import com.isep.algoprog.projet.shortestPath.Dijkstra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Guillaume on 18/05/2017.
 * algoprog-projet
 */
public class GraphTest {

	private static void readJson() throws IOException {
		byte[] data =  Files.readAllBytes(Paths.get("data.json"));

		ObjectMapper om = new ObjectMapper();
		Network network = om.readValue(data, Network.class);

		Station station = network.getStops().get("Montparnasse-Bienvenue");
		System.out.println(station);
	}

	public static void main(String[] args) throws IOException {
//		readJson();
		Graph graph = new Graph();
		graph.build("data.json");
        BFS myBfs = new BFS(graph, "Grands Boulevards");
        myBfs.printSP("Grands Boulevards", "Olympiades");


        Dijkstra myDijkstra = new Dijkstra(graph, "Grands Boulevards");
        myDijkstra.printSP("Grands Boulevards", "Olympiades");

        DiameterBFS diameter = new DiameterBFS(graph);

        DiameterDijkstra diameterDijkstra = new DiameterDijkstra(graph);
	}
}
