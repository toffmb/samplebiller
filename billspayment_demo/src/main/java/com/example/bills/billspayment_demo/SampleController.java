package com.example.bills.billspayment_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampleapp")
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

}