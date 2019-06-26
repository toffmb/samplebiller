package com.example.bills.billspayment_demo.infrastructure.dao;

import com.example.bills.billspayment_demo.core.Biller;
import com.example.bills.billspayment_demo.core.dao.BillerDAO;
import com.example.bills.billspayment_demo.infrastructure.entity.BillerEntity;
import com.example.bills.billspayment_demo.infrastructure.repository.BillerRepository;

import java.util.ArrayList;
import java.util.List;

public class BillerDAOImpl implements BillerDAO {

    private BillerRepository billerRepository;

    public BillerDAOImpl(BillerRepository billerRepository) { this.billerRepository = billerRepository; }

    @Override
    public List<Biller> findAllBillers() {
        List<BillerEntity> billerEntityGroup = billerRepository.findAll();
        List<Biller> billers = mapBillerEntities(billerEntityGroup);
        return billers;

    }

    private List<Biller> mapBillerEntities(List<BillerEntity> billerEntityGroup) {
        List<Biller> billers = new ArrayList<>();
        billerEntityGroup.forEach(billerEntity -> {
            Biller biller = Biller.builder()
                    .billerID(billerEntity.getBillerID())
                    .billerName(billerEntity.getBillerName())
                    .build();
            billers.add(biller);
        });

        return billers;
    }
}
