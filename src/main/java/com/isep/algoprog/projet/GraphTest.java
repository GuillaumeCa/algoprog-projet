
package com.isep.algoprog.projet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isep.algoprog.projet.Cluster.EdgeCounter;
import com.isep.algoprog.projet.Cluster.ShortestPath;
import com.isep.algoprog.projet.data.Network;
import com.isep.algoprog.projet.data.Station;
import com.isep.algoprog.projet.graph.Graph;

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

       // BFS myBfs = new BFS(graph, "Grands Boulevards");
       // myBfs.printSP("Grands Boulevards", "Olympiades");


      // Dijkstra myDijkstra = new Dijkstra(graph, "Edgar-Quinet");
		// myDijkstra.printSP("Edgar-Quinet", "Gare d'Austerlitz");


       // DiameterBFS diameter = new DiameterBFS(graph);
        // DiameterDijkstra diameterDijkstra = new DiameterDijkstra(graph);

		// Créer tout les ShortestPath pour chaque station//
		//ShortestPath shortestPath = new ShortestPath();
		//shortestPath.build(graph);

		// Créer tout les Edges sous le format Edge2 //
		//EdgeBuilder edgeBuilder=new EdgeBuilder();
		//edgeBuilder.edgeBuilder(graph);

		// Créer le TopEdges.json//
		//EdgeCounter edgeCounter= new EdgeCounter();
		//edgeCounter.build();
	}
}
