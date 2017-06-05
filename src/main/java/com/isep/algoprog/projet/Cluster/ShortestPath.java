package com.isep.algoprog.projet.Cluster;

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
import java.util.Map;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class ShortestPath {
    private ArrayList<String> station= new ArrayList<String>();
    private Map<ArrayList<String>,ArrayList<String>> ShortestPath = new HashMap<ArrayList<String>, ArrayList<String>>();

    public Map<ArrayList<String>, ArrayList<String>> getShortestPath() {
        return ShortestPath;
    }

    public void build(Graph g) throws IOException {
        Network test = g.getNetwork();
        for (String elem:test.getStops().keySet()) {
            station.add(elem);
        }
        for (String start:station) {
            File ff=new File("ShortestPath\\" +start +".json"); // définir l'arborescence
            ff.createNewFile();
            FileWriter ffw=new FileWriter(ff);
            JSONObject outerObject = new JSONObject();
            JSONArray outerArray = new JSONArray();
            for (String end:station) {
                JSONObject innerObject = new JSONObject();
                JSONArray innerArray = new JSONArray();
                if (start!=end){
                    ArrayList<String> edge =new ArrayList<String>();
                    ArrayList<String> path = new ArrayList<String>();
                    edge.add(start);
                    edge.add(end);
                    Dijkstra dijkstra = new Dijkstra(g,start);
                    path=dijkstra.printSP(start,end);
                    ShortestPath.put(edge,path);
                    innerObject.put("Path",path);
                    innerObject.put("End",end);
                    innerObject.put("Start",start);
                    System.out.println(ShortestPath.size());
                    outerArray.add(innerObject);
                }else{
                    innerObject.put("Path","");
                    innerObject.put("End",end);
                    innerObject.put("Start",start);
                    System.out.println(ShortestPath.size());
                    outerArray.add(innerObject);
                }
            }
            outerObject.put("ShortestPath",outerArray);
            ffw.write(outerObject.toJSONString());
            ffw.close(); // fermer le fichier à la fin des traitements
        }
    }
     public void test() throws IOException {
         File ff=new File("test.json"); // définir l'arborescence
         ff.createNewFile();
         FileWriter ffw=new FileWriter(ff);
         JSONObject outerObject = new JSONObject();
         JSONArray outerArray = new JSONArray();
        JSONObject innerObject = new JSONObject();
        JSONArray innerArray = new JSONArray();
        innerArray.add("pied");
        innerArray.add("pied");
        innerArray.add("pied");
        innerArray.add("pied");
        innerObject.put("Path",innerArray);
        innerObject.put("End","Paris");
        innerObject.put("Start","Orleans");
        outerArray.add(innerObject);
        outerObject.put("ShortestPath",outerArray);
         ffw.write(outerObject.toJSONString());
         ffw.close(); // fermer le fichier à la fin des traitements
     }

}
