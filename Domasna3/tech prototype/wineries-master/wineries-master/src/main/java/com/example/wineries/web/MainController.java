package com.example.wineries.web;

import com.example.wineries.model.Winery;
import com.example.wineries.service.WineryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class   MainController {
    private final WineryService wineryService;

    public MainController(WineryService wineryService) {
        this.wineryService = wineryService;
    }

    @GetMapping
    public String getMainPage(){
        return "homepage";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(){ return "register"; }

    @GetMapping("/add")
    public String getAddWinery(){ return "addwinery"; }

    @GetMapping("/search")
    public String getSearchWinery(Model model){
        model.addAttribute("list", wineryService.listAllWineries());
        return "search";
    }
    @PostMapping("/search")
    public String postSearchWinery(Model model, @RequestParam String city)
    {
        if(city==null)
            model.addAttribute("list",wineryService.listAllWineries());
        else
            model.addAttribute("list",wineryService.findByContains(city));
        return "search";
    }

    @PostMapping("/add")
    public String addWinery(Model model,
                              @RequestParam String name,
                              @RequestParam Double lon,
                              @RequestParam Double lat,
                              @RequestParam String city
                              ){
        System.out.println("***"
                +name+";"
                +";"
                +lon+";"
                +lat+";"
                +";"
                +city+";"
                +";"
                +"***");
        wineryService.saveWinery(new Winery(name,lat,lon,city));
        return "search";
    }
    @GetMapping("/getClosestWinery")
    public String userLocation(Model model)
    {
        model.addAttribute("list",wineryService.listAllWineries());
        return "locatedClosest";
    }
}