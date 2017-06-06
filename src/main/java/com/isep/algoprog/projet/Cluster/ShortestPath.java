package com.isep.algoprog.projet.Cluster;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isep.algoprog.projet.data.Network;
import com.isep.algoprog.projet.graph.Edge;
import com.isep.algoprog.projet.graph.Graph;
import com.isep.algoprog.projet.shortestPath.Dijkstra;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class ShortestPath {
    private ArrayList<String> station= new ArrayList<>();
    private List<Path> shortestPath= new ArrayList<>();

    public List<Path> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Path> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public void build(Graph g) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Network test = g.getNetwork();
        for (String elem:test.getStops().keySet()) {
            station.add(elem);
        }
        int index=0;
        for (String start:station) {
            ShortestPath shortestPath = new ShortestPath();
            List<Path> list = shortestPath.getShortestPath();
            System.out.println(index);
            for (String end:station) {
                if (start!=end){
                    ArrayList<String> edge =new ArrayList<String>();
                    ArrayList<String> path = new ArrayList<String>();
                    edge.add(start);
                    edge.add(end);
                    Dijkstra dijkstra = new Dijkstra(g,start);
                    path=dijkstra.printSP(start,end);
                    Path chemin= new Path(start,end,path);
                    list.add(chemin);
                }else{
                    Path chemin= new Path(start,end,null);
                    list.add(chemin);
                }
            }
            index++;
            shortestPath.setShortestPath(list);
            mapper.writeValue(new File("ShortestPath\\"+start + ".json"),shortestPath);
        }
    }
    @Override
    public String toString() {
        return "ShortestPath{" +
                "shortestPath=" + shortestPath +
                '}';
    }
}
