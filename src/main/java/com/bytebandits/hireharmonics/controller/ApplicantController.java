package com.bytebandits.hireharmonics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ApplicantController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
