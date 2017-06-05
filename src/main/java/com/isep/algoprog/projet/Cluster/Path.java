package com.isep.algoprog.projet.Cluster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class Path {
    private String Start;
    private String End;
    private List<String> Path=new ArrayList<>();

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public List<String> getPath() {
        return Path;
    }

    public void setPath(List<String> path) {
        Path = path;
    }

    public String getStart() {

        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }
}
