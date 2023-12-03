package com.example.wineries.bootstrap;

import com.example.wineries.repository.WineryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInsert {
    private final WineryRepository wineryRepository;

    public DataInsert(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    //@PostConstruct
//    public void init() throws FileNotFoundException {
//       BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ivans\\OneDrive\\Desktop\\final.txt"));
////String name, String location, String workingTime, Double lon, Double lat, String phoneNumber, String city, String website
//        br.lines()
//                .forEach(i->{
//                    String [] line = i.split("\\|");
//                    pharmacyRepository.save(new Pharmacy(line[2], line[3], line[7],
//                            Double.parseDouble(line[0]), Double.parseDouble(line[1]), line[5], line[4], line[6]));
//                });
//    }
}
