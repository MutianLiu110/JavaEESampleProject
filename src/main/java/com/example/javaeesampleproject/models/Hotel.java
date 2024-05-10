package com.example.javaeesampleproject.models;

import java.util.List;

public class Hotel {
    int id;
    String name;
    String description;
    String city;

    public Hotel(){}

    public Hotel(String name){
        super();
        this.name = name;
    }

    public Hotel(String name, String city){
        super();
        this.name = name;
        this.city = city;
    }

    public Hotel(int id, String name, String description, String city){
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
