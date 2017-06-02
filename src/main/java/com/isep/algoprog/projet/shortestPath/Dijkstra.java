package com.isep.algoprog.projet.shortestPath;

import com.isep.algoprog.projet.graph.Edge;
import com.isep.algoprog.projet.graph.Graph;

import java.util.*;

/**
 * Created by alizeefaytre on 02/06/2017.
 */
public class Dijkstra {

    private Map<String, Boolean> marked;
    private Map<String, String> previous;
    private Map<String, Double> distance;

    public Map<String, Double> getDistance() {
        return distance;
    }

    public Dijkstra(Graph G, String firstStation){
        marked = new HashMap<String, Boolean>();
        distance = new HashMap<String, Double>();
        previous = new HashMap<String, String>();

        for (String key:G.getNodes().keySet()) {
            marked.put(key, new Boolean(false));
            distance.put(key, Double.MAX_VALUE);
        }

        Queue<String> nodesToVisit = new LinkedList<String>();
        distance.put(firstStation, new Double(0));
        nodesToVisit.add(firstStation);

        while (nodesToVisit.size()>0){
            String station = nodesToVisit.poll();
            marked.put(station, new Boolean(true));
            Queue<String> neighbors = G.getNodes().get(station).getNeighbors();

            for (String neighbor:neighbors) {

                Double dist = new Double(0);
                for (Edge edge:G.getNodes().get(station).getEdges()) {
                    String source = "" ;
                    String dest = "" ;
                    for (String key:G.getNodes().keySet()) {
                        if(edge.getSource().equals(G.getNodes().get(key))){
                            source = key ;
                        }
                        if(edge.getDest().equals(G.getNodes().get(key))){
                            dest = key ;
                        }
                    }
                    if (source.equals(station) && dest.equals(neighbor)){
                        dist = edge.getDistance();
                    }
                }

                Double neighborDistance = distance.get(station) + dist;

                if(distance.get(neighbor) > neighborDistance){
                    distance.put(neighbor, neighborDistance);
                    previous.put(neighbor, station);
                    nodesToVisit.add(neighbor);
                }
            }
        }
    }

    public ArrayList<String> printSP(String firstStation,String lastStation){
        String prev = lastStation;
        ArrayList<String> stack = new ArrayList<String>();
        stack.add(lastStation);
        while (prev != firstStation){
            prev = previous.get(prev);
            stack.add(prev);
        }


        // Décommenter cette partie pour afficher dans la console le shortest path
        //  |
        //  v

        /*for (int i = stack.size()-1; i>=0; i--) {
            if (stack.get(i) == lastStation){
                System.out.print(stack.get(i));
            }
            else{
                System.out.print(stack.get(i) + " => ");
            }

        }*/
        return stack;
    }
}
