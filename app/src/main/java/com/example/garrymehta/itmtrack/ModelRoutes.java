package com.example.garrymehta.itmtrack;

public class ModelRoutes {

    private String routebusnumber;
    private String routeStops;

    public ModelRoutes(String routebusnumber, String routeStops) {
        this.routebusnumber = routebusnumber;
        this.routeStops = routeStops;
    }

    public String getRoutebusnumber() {
        return routebusnumber;
    }

    public String getRouteStops() {
        return routeStops;
    }
}
