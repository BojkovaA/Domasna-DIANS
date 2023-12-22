package com.example.wineries.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "wineries")
public class Winery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Double lat;

    Double lon;

    String city;

    public Winery(String name, Double lat, Double lon, String city) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
    }

    public Winery(){

    }
}