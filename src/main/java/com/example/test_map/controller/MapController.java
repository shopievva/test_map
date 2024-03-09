package com.example.test_map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MapController {

    @RequestMapping(value = "/", method = GET, headers = "Connection!=Upgrade")
    public String sendCoordinates(){
        return "map.html";
    }
}
