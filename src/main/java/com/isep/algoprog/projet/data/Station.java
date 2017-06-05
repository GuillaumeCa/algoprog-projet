package com.isep.algoprog.projet.data;


import java.util.List;

/**
 * Created by alizeefaytre on 22/05/2017.
 */
public class Station {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private List<String> lines;
    private List<Link> links;
    private Location location;

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", lines=" + lines +
                ", links=" + links +
                ", location=" + location +
                '}';
    }
}
