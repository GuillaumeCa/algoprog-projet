package com.isep.algoprog.projet.shortestPath;

import com.isep.algoprog.projet.graph.Edge;
import com.isep.algoprog.projet.graph.Graph;

import java.util.*;

import static java.lang.Boolean.TRUE;

/**
 * Created by alizeefaytre on 31/05/2017.
 */
public class BFS {

    private Map<String, Boolean> marked;
    private Map<String, String> previous;
    private Map<String, Double> distance;

    public Map<String, Double> getDistance() {
        return distance;
    }

    public BFS(Graph G, String firstStation){
        Queue<String> queue = new LinkedList<String>();

        marked = new HashMap<String, Boolean>();
        distance = new HashMap<String, Double>();
        previous = new HashMap<String, String>();

        marked.put(firstStation, new Boolean(true));
        distance.put(firstStation, new Double(0));
        queue.add(firstStation);

        while(!queue.isEmpty()){
            String activeNode = queue.poll();
            Queue<String> neighbors = G.getNodes().get(activeNode).getNeighbors(); // on recupere le noeud correspondant à la station activeNode et on demande les voisins

            while(!neighbors.isEmpty()){
                String neighbor = neighbors.poll();

                if (!marked.containsKey(neighbor)){
                    marked.put(neighbor, TRUE);
                    previous.put(neighbor, activeNode);
                    // on recupère la distance entre les deux stations
                    Double dist = new Double(0);
                    for (Edge edge:G.getNodes().get(activeNode).getEdges()) {
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
                        if (source.equals(activeNode) && dest.equals(neighbor)){
                            dist = edge.getDistance();
                        }
                    }
                    distance.put(neighbor, distance.get(activeNode)+ dist);
                    queue.add(neighbor);
                }
            }
        }

    }

    public boolean hasPathTo(String station){
        if(marked.containsKey(station)){
            return true;
        }
        return false;
    }

    public ArrayList<String> printSP(String firstStation,String lastStation){
        String prev = lastStation;
        ArrayList<String> stack = new ArrayList<String>();
        stack.add(lastStation);
        while (prev != firstStation){
           prev = previous.get(prev);
            stack.add(prev);
        }

        for (int i = stack.size()-1; i>=0; i--) {
            if (stack.get(i) == lastStation){
                System.out.print(stack.get(i));
            }
            else{
                System.out.print(stack.get(i) + " => ");
            }

        }
        return stack;
    }

}
