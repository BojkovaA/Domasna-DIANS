package com.example.wineries.bootstrap;

import com.example.wineries.repository.WineryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInsert {
    private final WineryRepository wineryRepository;

    public DataInsert(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

}
