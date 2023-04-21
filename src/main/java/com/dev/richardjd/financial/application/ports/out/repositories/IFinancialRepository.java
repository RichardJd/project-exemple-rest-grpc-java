package com.dev.richardjd.financial.application.ports.out.repositories;

import com.dev.richardjd.financial.domain.entities.FinancialEntity;

import java.util.List;

public interface IFinancialRepository {

    List<FinancialEntity> findAll();

    FinancialEntity findById(Long id);

    Integer create(FinancialEntity financialEntity);

    Integer deleteById(Long id);
}
