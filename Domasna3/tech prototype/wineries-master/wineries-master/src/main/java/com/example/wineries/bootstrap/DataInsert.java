package com.example.wineries.bootstrap;

import com.example.wineries.model.Winery;
import com.example.wineries.repository.WineryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInsert {
    public static List<Winery> wineries;
    private final WineryRepository wineryRepository;

    public DataInsert(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }
    @PostConstruct
    public void init() {
        wineries = new ArrayList<>();


        if (wineryRepository.count() == 0) {
            wineries.add(new Winery("Chateau Sopot",22.0048024,41.436124,"Skopje"));
            wineries.add(new Winery("Chateau Sopot",22.0048024,41.436124,"Veles"));
            wineries.add(new Winery("Chateau Sopot",22.0048024,41.436124,"Negotino"));
            wineries.add(new Winery("Chateau Sopot",22.0048024,41.436124,"Kavadarci"));
            wineryRepository.saveAll(wineries);
        }

    }

}
