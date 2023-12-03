package com.example.wineries.service.impl;

import com.example.wineries.model.Winery;
import com.example.wineries.model.exception.CityNotFoundException;
import com.example.wineries.repository.WineryRepository;
import com.example.wineries.service.WineryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WineryServiceImpl implements WineryService {
    private final WineryRepository wineryRepository;

    public WineryServiceImpl(WineryRepository wineryRepository){
        this.wineryRepository = wineryRepository;
    }

    @Override
    public List<Winery> listAllWineries() {
        return wineryRepository.findAll();
    }

    @Override
    public List<Winery> listAllWineriesByCity(String city) {
        if (wineryRepository.findAllByCity(city) == null) {
            try {
                throw new CityNotFoundException("City could not be found!");
            } catch (CityNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } else
            return wineryRepository.findAllByCity(city);
    }
    @Override
    public List<Winery> findByContains(String city) {
        return wineryRepository.findAllByCityContains(city);
    }
}
