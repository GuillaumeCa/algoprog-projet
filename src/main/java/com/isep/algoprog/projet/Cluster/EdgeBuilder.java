package com.isep.algoprog.projet.Cluster;

import com.isep.algoprog.projet.graph.Edge;
import com.isep.algoprog.projet.graph.Graph;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class EdgeBuilder {
    public void edgeBuilder (Graph graph) throws IOException {
        JSONObject outerObject = new JSONObject();
        JSONArray outerArray = new JSONArray();
        File ff=new File("Edge.json"); // définir l'arborescence
        ff.createNewFile();
        FileWriter ffw=new FileWriter(ff);
        Map<String,String> edge = new HashMap<String, String>();
        for (String elem:graph.getNodes().keySet()) {
            JSONObject innerObject = new JSONObject();
            for (Edge ed:graph.getNodes().get(elem).getEdges()){
                innerObject.put("source",ed.getSource().getData().getName());
                innerObject.put("dest",ed.getDest().getData().getName());
                innerObject.put("line",ed.getLine());
                innerObject.put("distance",ed.getDistance());
            }
            outerArray.add(innerObject);
            ffw.write(outerArray.toJSONString());
        }
        ffw.close(); // fermer le fichier à la fin des traitements
    }
}
