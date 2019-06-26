package com.example.bills.billspayment_demo.core.dao;

import com.example.bills.billspayment_demo.core.Biller;

import java.util.List;

public interface BillerDAO {

    List<Biller> findAllBillers();
}
