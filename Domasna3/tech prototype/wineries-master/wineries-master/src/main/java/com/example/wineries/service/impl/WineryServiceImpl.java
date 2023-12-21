package com.example.wineries.service.impl;

import com.example.wineries.model.Winery;
import com.example.wineries.model.exception.CityNotFoundException;
import com.example.wineries.model.exception.WineryAlreadyExistsException;
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

    @Override
    public void saveWinery(Long id, String name, String lon, String lat, String city) {
        if(this.wineryRepository.findById(id).isPresent())
            try {
                throw new WineryAlreadyExistsException(id);
            } catch (WineryAlreadyExistsException e) {
                e.printStackTrace();
            }
        this.wineryRepository.findAll().add(new Winery(name,Double.valueOf(lon),
                Double.valueOf(lat),city));
    }

    @Override
    public void saveWinery(Winery winery) {
        wineryRepository.save(winery);
    }

    @Override
    public Winery findClosestTo(Winery w) {
        List<Winery> all=this.listAllWineries();
        Double distanceBetweenWineries=Double.MAX_VALUE;
        Long idOfClosest=Long.valueOf(0);
        for(Winery winery:all)
        {
            Double helper=distance(winery.getLat(),winery.getLon(),w.getLat(),w.getLon());
            if(helper==Double.valueOf(0))
                continue;
            if(helper<distanceBetweenWineries)
            {
                distanceBetweenWineries=helper;
                idOfClosest=winery.getId();
            }
        }
        Winery closest=wineryRepository.getById(idOfClosest);
        return closest;
    }

    private Double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return Double.valueOf(0);
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            return (Double.valueOf(dist));
        }
    }
}
