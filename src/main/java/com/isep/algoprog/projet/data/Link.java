package com.isep.algoprog.projet.data;


/**
 * Created by alizeefaytre on 22/05/2017.
 */
public class Link {
    private String line;
    private String station_name;

    public Link() {
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    @Override
    public String toString() {
        return "Link{" +
                "line='" + line + '\'' +
                ", station_name='" + station_name + '\'' +
                '}';
    }
}
