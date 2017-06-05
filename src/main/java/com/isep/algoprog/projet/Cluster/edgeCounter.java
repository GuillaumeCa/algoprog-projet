package com.isep.algoprog.projet.Cluster;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isep.algoprog.projet.data.Network;
import javafx.scene.shape.Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class edgeCounter {
    private ArrayList<Path> ShortestPath= new ArrayList<Path>();

    public ArrayList<Path> getShortestPath() {
        return ShortestPath;
    }

    public void setShortestPath(ArrayList<Path> shortestPath) {
        ShortestPath = shortestPath;
    }

    public void build() throws IOException {
        byte[] data = Files.readAllBytes(Paths.get("Avenue Emile-Zola.json"));
        ObjectMapper om = new ObjectMapper();
        edgeCounter test = om.readValue(data, edgeCounter.class);
        for (Path elem:test.getShortestPath()) {
            System.out.println(elem.toString());
        }

    }

}
