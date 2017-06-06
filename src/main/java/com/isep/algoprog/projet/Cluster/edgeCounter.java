package com.isep.algoprog.projet.Cluster;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isep.algoprog.projet.data.Network;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class EdgeCounter {
    private ArrayList<Path> ShortestPath= new ArrayList<>();
    private Map<String,Integer> mostRecurent;
    Map<String,Integer> top = new HashMap<>();

    public ArrayList<Path> getShortestPath() {
        return ShortestPath;
    }

    public void setShortestPath(ArrayList<Path> shortestPath) {
        ShortestPath = shortestPath;
    }

    public Map<String, Integer> getMostRecurent() {
        return mostRecurent;
    }

    public void setMostRecurent(Map<String, Integer> mostRecurent) {
        this.mostRecurent = mostRecurent;
    }

    public void build() throws IOException {
        Map<String, Integer> mostRecurent = new HashMap<>();
        String folder="ShortestPath\\";
        File file = new File(folder);
        File[] files = file.listFiles();
        for (File fichier:files) {
            System.out.println(fichier.getName());
            byte[] data = Files.readAllBytes(Paths.get(fichier.getAbsolutePath()));
            ObjectMapper om = new ObjectMapper();
            ShortestPath test = om.readValue(data, ShortestPath.class);
            List<Path> list = test.getShortestPath();
            for (Path elem : list) {
                List<String> path = elem.getPath();
                if (path != null) {
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
        }
        setMostRecurent(mostRecurent);
        System.out.println(mostRecurent);
        Max();
    }

    public Map<String, Integer> getTop() {
        return top;
    }

    public void setTop(Map<String, Integer> top) {
        this.top = top;
    }

    public void Max() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Integer> map = getMostRecurent();
        Map<String,Integer> top = new HashMap<>();
        int tampon=0;

        String index="";
        for (int i=0; i<10;i++) {
            for (String elem : map.keySet()) {
                if (!top.containsKey(elem)) {
                    if (map.get(elem) > tampon) {
                        tampon = map.get(elem);
                        index = elem;
                    }
                }
            }
            top.put(index,tampon);
            tampon=0;
        }
        setTop(top);
        mapper.writeValue(new File("TopEdges.json"),top);
    }

}
