package com.isep.algoprog.projet.Cluster;

/**
 * Created by Alex-PC on 06/06/2017.
 */
public class Edge2 {
    private String source;
    private String dest;
    private String line;
    private double distance;

    @Override
    public String toString() {
        return "Edge2{" +
                "source='" + source + '\'' +
                ", dest='" + dest + '\'' +
                ", line='" + line + '\'' +
                ", distance=" + distance +
                '}';
    }

    public Edge2(String source, String dest, String line, double distance) {
        this.source = source;
        this.dest = dest;
        this.line = line;
        this.distance = distance;
    }
}
