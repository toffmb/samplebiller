package com.example.bills.billspayment_demo.configuration;

import com.example.bills.billspayment_demo.core.dao.BillerDAO;
import com.example.bills.billspayment_demo.core.dao.PaymentDAO;
import com.example.bills.billspayment_demo.core.service.BillerService;
import com.example.bills.billspayment_demo.core.service.impl.BillerServiceImpl;
import com.example.bills.billspayment_demo.core.service.PaymentService;
import com.example.bills.billspayment_demo.core.service.impl.PaymentServiceImpl;
import com.example.bills.billspayment_demo.infrastructure.repository.BillerRepository;
import com.example.bills.billspayment_demo.infrastructure.dao.BillerDAOImpl;
import com.example.bills.billspayment_demo.infrastructure.repository.PaymentRepository;
import com.example.bills.billspayment_demo.infrastructure.dao.PaymentDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    BillerDAO billerDAO(BillerRepository billerRepository) {
        return new BillerDAOImpl(billerRepository);
    }

    @Bean
    BillerService billerService(BillerDAO billerDAO) {
        return new BillerServiceImpl(billerDAO);
    }

    @Bean
    PaymentService paymentService(PaymentDAO paymentDAO) { return new PaymentServiceImpl(paymentDAO); }

    @Bean
    PaymentDAO paymentDAO(PaymentRepository paymentRepository) { return new PaymentDAOImpl(paymentRepository); }
}
