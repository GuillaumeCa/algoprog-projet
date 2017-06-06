package com.isep.algoprog.projet.Cluster;

/**
 * Created by Alex-PC on 06/06/2017.
 */
public class Edge2 {
    private String source;
    private String dest;
    private String line;
    private double distance;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

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
