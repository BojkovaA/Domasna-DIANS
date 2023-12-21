package com.example.wineries.service;

import com.example.wineries.model.Winery;

import java.util.List;

public interface WineryService {
    List<Winery> listAllWineries();
    List<Winery> listAllWineriesByCity(String city);
    List<Winery> findByContains(String city);

    void saveWinery(Long id, String name, String lat, String lon, String city);
    void saveWinery(Winery winery);
    Winery findClosestTo(Winery w);

}

