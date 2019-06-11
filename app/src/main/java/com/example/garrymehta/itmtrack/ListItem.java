package com.example.garrymehta.itmtrack;

public class ListItem {

    private String busnumber;
    private  String busregnumber;
    private  String busdrivername;

    public ListItem(String busnumber, String busregnumber, String busdrivername) {
        this.busnumber = busnumber;
        this.busregnumber = busregnumber;
        this.busdrivername = busdrivername;
    }

    public String getBusnumber() {
        return busnumber;
    }

    public String getBusregnumber() {
        return busregnumber;
    }

    public String getBusdrivername() {
        return busdrivername;
    }
}
