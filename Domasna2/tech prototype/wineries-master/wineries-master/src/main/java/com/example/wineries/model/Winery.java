package com.example.wineries.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vinarija")
public class Winery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String name;

    String location;

    String workingTime;

    Double lon;

    Double lat;

    String phoneNumber;

    String city;

    String website;

    public Winery(String name, String location, String workingTime, Double lon, Double lat, String phoneNumber, String city, String website) {
        this.name = name;
        this.location = location;
        this.workingTime = workingTime;
        this.lon = lon;
        this.lat = lat;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.website = website;
    }

    public Winery(){

    }
}