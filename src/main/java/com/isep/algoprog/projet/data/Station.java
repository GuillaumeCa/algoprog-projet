package com.isep.algoprog.projet.data;


import java.util.List;

/**
 * Created by alizeefaytre on 22/05/2017.
 */
public class Station {

    private String name;
    private List<Link> links;
    private Location location;

    public Station() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
