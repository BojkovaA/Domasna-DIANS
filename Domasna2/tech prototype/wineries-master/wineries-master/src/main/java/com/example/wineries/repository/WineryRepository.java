package com.example.wineries.repository;

import com.example.wineries.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineryRepository extends JpaRepository<Winery, Long> {
    @Override
    List<Winery> findAll();
    List<Winery> findAllByCity(String location);
    List<Winery> findAllByCityContains(String city);
}
