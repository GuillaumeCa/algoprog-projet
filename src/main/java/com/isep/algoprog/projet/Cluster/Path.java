package com.isep.algoprog.projet.Cluster;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Alex-PC on 05/06/2017.
 */
public class Path {
    private String start;
    private String end;
    private List<String> path;


    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Path{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", path=" + path +
                '}';
    }

    public String getStart() {
        return start;
    }

    public Path() {
    }

    public Path(String start, String end, List<String> path) {

        this.start = start;
        this.end = end;
        this.path = path;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
