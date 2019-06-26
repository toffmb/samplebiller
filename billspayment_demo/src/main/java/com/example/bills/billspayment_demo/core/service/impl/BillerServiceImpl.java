package com.example.bills.billspayment_demo.core.service.impl;

import com.example.bills.billspayment_demo.core.dao.BillerDAO;
import com.example.bills.billspayment_demo.core.Biller;
import com.example.bills.billspayment_demo.core.service.BillerService;

import java.util.List;

public class BillerServiceImpl implements BillerService {

    BillerDAO billerDAO;

    public BillerServiceImpl(BillerDAO billerDAO) {
        this.billerDAO = billerDAO;
    }

    @Override
    public List<Biller> getBillers() {
        return billerDAO.findAllBillers();
    }
}
