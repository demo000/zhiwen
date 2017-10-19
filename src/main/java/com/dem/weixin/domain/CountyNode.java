package com.dem.weixin.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DEM on 2017/5/7.
 */
public class CountyNode {
    private String name;
    private List<String> street =new ArrayList<>();

    public CountyNode() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStreet() {
        return street;
    }

    public void setStreet(List<String> street) {
        this.street = street;
    }

    public String toString(){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
