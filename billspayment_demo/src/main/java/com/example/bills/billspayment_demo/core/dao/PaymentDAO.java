package com.example.bills.billspayment_demo.core.dao;

import com.example.bills.billspayment_demo.core.Biller;
import com.example.bills.billspayment_demo.core.Payment;

import java.util.List;


public interface PaymentDAO {
    Payment savePayment(Payment payment);
    List<Payment> getPaymentHistoryByBiller(Biller biller);
    List<Payment> getAllPaymentHistoryOfUser(String accountName);
}
