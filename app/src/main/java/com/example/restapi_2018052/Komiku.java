package com.example.restapi_2018052;

import java.util.ArrayList;

public class Komiku {
    private String next;
    private Object previous;
    private int count;
    public ArrayList<RestItem> results;

    public String getNext(){
        return next;
    }

    public Object getPrevious(){
        return previous;
    }

    public int getCount(){
        return count;
    }

    public ArrayList<RestItem> getResults(){
        return results;
    }
}
