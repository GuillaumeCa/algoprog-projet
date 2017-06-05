package com.isep.algoprog.projet.Cluster;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class Path {
    private String Start;
    private String End;
    private ArrayList<String> Path=new ArrayList<String>();

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public ArrayList<String> getPath() {
        return Path;
    }

    public void setPath(ArrayList<String> path) {
        Path = path;
    }
}
