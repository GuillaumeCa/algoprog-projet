package com.isep.algoprog.projet.Cluster;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isep.algoprog.projet.data.Network;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class edgeCounter {
    private ArrayList<Path> ShortestPath= new ArrayList<>();


    public void build() throws IOException {
        byte[] data = Files.readAllBytes(Paths.get("Avenue Emile-Zola.json"));
        ObjectMapper om = new ObjectMapper();
        ShortestPath test = om.readValue(data, ShortestPath.class);
        List<Path> list = test.getShortestPath();
        Map<String,Integer> mostRecurent=new HashMap<>();
        for (Path elem:list) {
            List<String> path = elem.getPath();
            if (path!=null) {
                for (int i = 0; i < path.size(); i++) {
                    if (i != 0) {
                        if (mostRecurent.containsKey(path.get(i - 1) + " <-> " + path.get(i))) {
                            int tampon = mostRecurent.get(path.get(i - 1) + " <-> " + path.get(i));
                            mostRecurent.put(path.get(i - 1) + " <-> " + path.get(i), tampon + 1);
                        } else {
                            mostRecurent.put(path.get(i - 1) + " <-> " + path.get(i), 1);
                        }
                    }
                }
            }
        }
        System.out.println(mostRecurent);




    }

}
