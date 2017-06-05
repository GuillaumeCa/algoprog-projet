package com.isep.algoprog.projet.Cluster;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isep.algoprog.projet.data.Network;
import javafx.scene.shape.Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class edgeCounter {
    private List<Path> ShortestPath= new ArrayList<Path>();

    public List<Path> getShortestPath() {
        return ShortestPath;
    }

    public void setShortestPath(List<Path> shortestPath) {
        ShortestPath = shortestPath;
    }

    public void build() throws IOException {
        byte[] data = Files.readAllBytes(Paths.get("test.json"));
        ObjectMapper om = new ObjectMapper();
        edgeCounter test = om.readValue(data, edgeCounter.class);
        System.out.print(test);


    }

}
