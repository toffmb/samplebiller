package com.example.bills.billspayment_demo.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "PAYMENT")
public class PaymentEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentID;

    @ManyToOne
    @JoinColumn(name = "BILLER_ID", referencedColumnName = "ID")
    private BillerEntity billerEntity;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "DATE_PAID")
    private Date datePaid;

    @Column(name = "AMOUNT")
    private BigDecimal totalAmount;

    @Column(name = "AMOUNT_PAID")
    private BigDecimal amountToBePaid;

    @Column(name = "CHANGE")
    private BigDecimal change;
}

