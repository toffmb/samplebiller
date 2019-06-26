package com.example.bills.billspayment_demo.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    private Long paymentID;
    private Biller biller;
    private String accountName;
    private Date datePaid;
    private BigDecimal totalAmount;
    private BigDecimal amountToBePaid;
    private BigDecimal change;
}
