package com.example.bills.billspayment_demo.presentation;

import com.example.bills.billspayment_demo.core.Payment;
import com.example.bills.billspayment_demo.core.service.PaymentService;
import com.example.bills.billspayment_demo.presentation.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/payments")
    public List<Payment> getPaymentHistory(@RequestHeader String accountName) {
        return paymentService.getPaymentHistory(accountName);
    }

    @PostMapping(value = "/pay")
    public Boolean payBills(@RequestBody PaymentDTO paymentDTO) {
        return null != paymentService.payBills(paymentDTO);
    }
}
