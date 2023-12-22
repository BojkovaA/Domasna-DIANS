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
            if (wineryRepository.count() == 0) {
                wineryRepository.save(new Winery("Chateau Sopot", 41.777774, 21.774216, "Veles"));
                wineryRepository.save(new Winery("Tristo Winery", 41.7888, 21.7911, "Veles"));
                wineryRepository.save(new Winery("Kocev Family Wines", 41.7097, 21.7878, "Veles"));
                wineryRepository.save(new Winery("Izvorno Winery", 41.6038, 21.6928, "Veles"));
                wineryRepository.save(new Winery("Popova Kula", 41.4109967, 22.2261756, "Demir Kapija"));
                wineryRepository.save(new Winery("Bovin Winery", 41.4943704, 22.0915153, "Negotino"));
            }

            List<Winery> wineries = wineryRepository.findAll();
        }

}
