package com.isep.algoprog.projet.shortestPath;

import com.isep.algoprog.projet.graph.Graph;
import com.isep.algoprog.projet.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alizeefaytre on 31/05/2017.
 */
public class Diameter {

    public Diameter(Graph G){
        Map<ArrayList<String>, Double> spList = new HashMap<ArrayList<String>, Double>();
        for (String node:G.getNodes().keySet()) {
            BFS bfs = new BFS(G, node);
            for (String secondNode:G.getNodes().keySet()) {
                if (!node.equals(secondNode)){
                    spList.put(bfs.printSP(node, secondNode), new Double(bfs.printSP(node, secondNode).size()));
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
        System.out.println("le diametre du graph est : " + spList.get(key));
        System.out.println("et le shortest path correspondant est : ");
        for (String s:key) {
            System.out.print(s + " || ");
        }
    }
}
