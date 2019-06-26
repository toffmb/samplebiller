package com.example.bills.billspayment_demo.core.service.impl;

import com.example.bills.billspayment_demo.core.Payment;
import com.example.bills.billspayment_demo.core.dao.PaymentDAO;
import com.example.bills.billspayment_demo.core.service.PaymentService;
import com.example.bills.billspayment_demo.presentation.dto.PaymentDTO;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    PaymentDAO paymentDAO;

    public PaymentServiceImpl(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public List<Payment> getPaymentHistory(String accountName) {
        return paymentDAO.getAllPaymentHistoryOfUser(accountName);

    }

    @Override
    public Payment payBills(PaymentDTO paymentDTO) {
        Payment payment = mapPaymentRequestToPayment(paymentDTO);
        return paymentDAO.savePayment(payment);
    }

    private Payment mapPaymentRequestToPayment(PaymentDTO paymentDTO) {
        Payment payment = Payment.builder()
                .biller(paymentDTO.getBiller())
                .amountToBePaid(paymentDTO.getAmountToBePaid())
                .totalAmount(paymentDTO.getTotalAmount())
                .accountName(paymentDTO.getAccountName())
                .build();
        return payment;
    }
}
