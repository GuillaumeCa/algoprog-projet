package com.isep.algoprog.projet.shortestPath;

import com.isep.algoprog.projet.graph.Edge;
import com.isep.algoprog.projet.graph.Graph;
import com.isep.algoprog.projet.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alizeefaytre on 02/06/2017.
 */
public class DiameterDijkstra {
    private List<String> key;
    private Graph G;

    public DiameterDijkstra(Graph G){
        this.G = G;
        Map<ArrayList<String>, Double> spList = new HashMap<ArrayList<String>, Double>();
        for (String node:G.getNodes().keySet()) {
            Dijkstra dijkstra = new Dijkstra(G, node);
            for (String secondNode:G.getNodes().keySet()) {
                if (!node.equals(secondNode)){
                    spList.put(dijkstra.printSP(node, secondNode), dijkstra.getDistance().get(secondNode));
                }
            }
        }

        Double lgPath = new Double(0);
        key = new ArrayList<String>();
        for (ArrayList<String> distance:spList.keySet()) {
            if (spList.get(distance)>lgPath){
                lgPath = spList.get(distance);
                key = distance;
            }
        }

        System.out.println(" ");
        System.out.println("le diametre du graph avec Dijkstra est : " + spList.get(key));
        System.out.println("et le shortest path correspondant est : ");
        for (String s:key) {
            System.out.print(s + " || ");
        }
    }

    public void printDistanceLP(){
        System.out.println("Les distances entre les stations sur le longest path sont :");
        for (int i = 0; i < key.size(); i++) {
            String station = key.get(i);
            if (station != key.get(key.size()-1)){
                String nextStation = key.get(i+1);
                List<Edge> edges = G.getNodes().get(station).getEdges();
                Double distance = new Double(0);
                for (Edge edge: edges) {
                    Node source = G.getNodes().get(station);
                    Node dest = G.getNodes().get(nextStation);
                    if (edge.getSource().equals(source) && edge.getDest().equals(dest)){
                        distance = edge.getDistance();
                    }
                }

                System.out.println(station + " - " + nextStation + ": " + distance.toString());
            }
        }
    }
}
