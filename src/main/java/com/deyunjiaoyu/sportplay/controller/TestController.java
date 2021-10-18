package com.deyunjiaoyu.sportplay.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("/test")
    public  String testHl(){

        return "来了，老弟";

    }
}
