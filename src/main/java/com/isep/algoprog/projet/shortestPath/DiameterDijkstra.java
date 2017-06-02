package com.isep.algoprog.projet.shortestPath;

import com.isep.algoprog.projet.graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alizeefaytre on 02/06/2017.
 */
public class DiameterDijkstra {

    public DiameterDijkstra(Graph G){
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
        ArrayList<String> key = new ArrayList<String>();
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
}
