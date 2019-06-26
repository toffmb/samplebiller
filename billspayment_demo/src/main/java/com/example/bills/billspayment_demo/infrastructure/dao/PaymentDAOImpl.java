package com.example.bills.billspayment_demo.infrastructure.dao;

import com.example.bills.billspayment_demo.core.Biller;
import com.example.bills.billspayment_demo.core.Payment;
import com.example.bills.billspayment_demo.core.dao.PaymentDAO;
import com.example.bills.billspayment_demo.infrastructure.entity.BillerEntity;
import com.example.bills.billspayment_demo.infrastructure.entity.PaymentEntity;
import com.example.bills.billspayment_demo.infrastructure.repository.PaymentRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    private PaymentRepository paymentRepository;

    public PaymentDAOImpl(PaymentRepository paymentRepository) { this.paymentRepository = paymentRepository; }

    @Override
    public Payment savePayment(Payment payment) {
        BillerEntity billerEntity = mapBillerToBillerEntity(payment);
        PaymentEntity paymentEntityToSave = mapPaymentEntityToBeSaved(payment, billerEntity);
        paymentRepository.save(paymentEntityToSave);
        return payment;
    }

    @Override
    public List<Payment> getPaymentHistoryByBiller(Biller biller) {
        return null;
    }

    @Override
    public List<Payment> getAllPaymentHistoryOfUser(String accountName) {
        List<PaymentEntity> paymentEntityGroup = paymentRepository.findAllByAccountName(accountName);
        List<Payment> payments = mapPaymentEntities(paymentEntityGroup);
        return payments;
    }

    private List<Payment> mapPaymentEntities(List<PaymentEntity> paymentEntitiesGroup) {
        List<Payment> payments = new ArrayList<>();
        paymentEntitiesGroup.forEach(paymentEntity -> {
            Biller biller = maBillerEntityToBiller(paymentEntity);
            Payment payment = mapPaymentEntityToPayment(paymentEntity, biller);
            payments.add(payment);
        });

        return payments;
    }

    private BillerEntity mapBillerToBillerEntity(Payment payment) {
        return BillerEntity.builder()
                .billerID(payment.getBiller().getBillerID())
                .billerName(payment.getBiller().getBillerName())
                .build();
    }

    private PaymentEntity mapPaymentEntityToBeSaved(Payment payment, BillerEntity billerEntity) {
        return PaymentEntity.builder()
                .paymentID(payment.getPaymentID())
                .accountName(payment.getAccountName())
                .amountToBePaid(payment.getAmountToBePaid())
                .totalAmount(payment.getTotalAmount())
                .change(getChangeFromTotalAmountAndAmountPaid(payment))
                .datePaid(getDateToday())
                .billerEntity(billerEntity)
                .build();
    }

    private BigDecimal getChangeFromTotalAmountAndAmountPaid(Payment payment) {
        return payment.getTotalAmount().subtract(payment.getAmountToBePaid());
    }

    private java.util.Date getDateToday() {
        return Date.valueOf(java.time.LocalDate.now().toString());

    }

    private Biller maBillerEntityToBiller(PaymentEntity paymentEntity) {
        return Biller.builder()
                .billerID(paymentEntity.getBillerEntity().getBillerID())
                .billerName(paymentEntity.getBillerEntity().getBillerName())
                .build();
    }

    private Payment mapPaymentEntityToPayment(PaymentEntity paymentEntity, Biller biller) {
        return Payment.builder()
                .paymentID(paymentEntity.getPaymentID())
                .biller(biller)
                .accountName(paymentEntity.getAccountName())
                .amountToBePaid(paymentEntity.getAmountToBePaid())
                .totalAmount(paymentEntity.getTotalAmount())
                .change(paymentEntity.getChange())
                .datePaid(paymentEntity.getDatePaid())
                .build();
    }

}
