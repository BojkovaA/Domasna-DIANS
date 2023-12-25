package com.example.wineries.bootstrap;

import com.example.wineries.model.User;
import com.example.wineries.model.Winery;
import com.example.wineries.repository.UserRepository;
import com.example.wineries.repository.WineryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInsert {
    public static List<Winery> wineries;
    public static List<User> users;
    private final WineryRepository wineryRepository;
    private final UserRepository userRepository;

    public DataInsert(WineryRepository wineryRepository, UserRepository userRepository) {
        this.wineryRepository = wineryRepository;
        this.userRepository = userRepository;
    }
        @PostConstruct
        public void init() {
        wineries= new ArrayList<>();
        users = new ArrayList<>();
            if (wineryRepository.count() == 0) {
                wineries.add(new Winery("Chateau Sopot", 41.777774, 21.774216, "Veles"));
                wineries.add(new Winery("Tristo Winery", 41.7888, 21.7911, "Veles"));
                wineries.add(new Winery("Kocev Family Wines", 41.7097, 21.7878, "Veles"));
                wineries.add(new Winery("Izvorno Winery", 41.6038, 21.6928, "Veles"));
                wineries.add(new Winery("Popova Kula", 41.4109967, 22.2261756, "Demir Kapija"));
                wineries.add(new Winery("Queen Maria", 41.4141902, 22.2229754, "Demir Kapija"));
                /*
                wineries.add(new Winery("Pivka", 41.4919, 22.093, "Negotino"));
                wineries.add(new Winery("Bovin Winery", 41.4943704, 22.0915153, "Negotino"));
                wineries.add(new Winery("Domain Lepovo", 41.5180203, 22.0341129, "Negotino"));
                wineries.add(new Winery("Skovin", 41.9956025, 21.431031, "Skopje"));
                wineries.add(new Winery("Kamnik", 42.0078222, 21.4902127, "Skopje"));
                wineries.add(new Winery("Vinarija Stobi", 41.581119 , 21.9375971, "Stobi"));
                wineries.add(new Winery("Lazar Winery", 41.5465, 21.9725, "Stobi"));
                wineries.add(new Winery("Zaharchev Winery and Distillery", 41.436124, 22.0048024, "Kavadarci"));
                */


            }

            wineryRepository.saveAll(wineries);

            if(userRepository.count() == 0){
                users.add(new User("user1@mail.com","user1","user1","user1"));
                /*
                users.add(new User("user2@mail.com","user2","user2","user2"));
                 */
            }
            userRepository.saveAll(users);
    }

}
