package com.example.bills.billspayment_demo.core.service;

import com.example.bills.billspayment_demo.core.Payment;
import com.example.bills.billspayment_demo.presentation.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<Payment> getPaymentHistory(String accountName);
    Payment payBills(PaymentDTO payment);
}
