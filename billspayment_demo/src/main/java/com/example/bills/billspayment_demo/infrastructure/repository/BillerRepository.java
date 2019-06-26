package com.example.bills.billspayment_demo.infrastructure.repository;

import com.example.bills.billspayment_demo.infrastructure.entity.BillerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillerRepository extends JpaRepository<BillerEntity, Long> {
}
