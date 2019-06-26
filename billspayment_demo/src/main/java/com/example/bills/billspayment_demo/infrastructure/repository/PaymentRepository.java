package com.example.bills.billspayment_demo.infrastructure.repository;

import com.example.bills.billspayment_demo.infrastructure.entity.BillerEntity;
import com.example.bills.billspayment_demo.infrastructure.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
    List<PaymentEntity> findAllByBillerEntity(BillerEntity biller);
    List<PaymentEntity> findAllByAccountName(String accountName);
}
