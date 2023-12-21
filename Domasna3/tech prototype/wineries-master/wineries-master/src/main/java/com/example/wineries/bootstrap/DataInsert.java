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
            wineries.add(new Winery("Chateau Sopot",41.777774,21.774216,"Veles"));
            wineries.add(new Winery("Popova Kula",41.4109967,22.2261756,"Demir Kapija"));
            wineries.add(new Winery("Bovin Winery",41.4943704,22.0915153,"Negotino"));
            wineryRepository.saveAll(wineries);
        }

    }

}
