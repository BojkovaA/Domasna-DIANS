package com.example.wineries.web;

import com.example.wineries.service.WineryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
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
        //model.addAttribute("list", wineryService.listAllWineries());
        return "search";
    }
    @GetMapping("/demoUserRegister")
    public String demoUserRegister(Model model)
    {
        return "demoUserRegister";
    }
    @GetMapping("/demoUserLogin")
    public String demoUserLogin(Model model)
    {
        return "demoUserLogin";
    }
    @PostMapping("/search")
    public String postSearchWinery(Model model, @RequestParam String city)
    {
        // if(city==null)
        // model.addAttribute("list",wineryService.listAllWineries());
        //else
        // model.addAttribute("list",wineryService.findByContains(city));
        return "search";
    }
}