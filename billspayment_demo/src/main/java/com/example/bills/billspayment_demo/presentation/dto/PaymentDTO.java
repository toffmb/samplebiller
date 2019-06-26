package com.example.bills.billspayment_demo.presentation.dto;

import com.example.bills.billspayment_demo.core.Biller;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private Biller biller;
    private String accountName;
    private BigDecimal totalAmount;
    private BigDecimal amountToBePaid;
}
