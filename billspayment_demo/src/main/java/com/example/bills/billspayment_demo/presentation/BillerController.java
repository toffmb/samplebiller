package com.example.bills.billspayment_demo.presentation;

import com.example.bills.billspayment_demo.core.Biller;
import com.example.bills.billspayment_demo.core.service.BillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class BillerController {

    private BillerService billerService;

    public BillerController(BillerService billerService) {
        this.billerService = billerService;
    }

    @GetMapping(value = "/billers")
    public List<Biller> getBillerTest() {
        return billerService.getBillers();
    }
}
