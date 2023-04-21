package com.dev.richardjd.financial.application.ports.in.services;

import com.dev.richardjd.financial.adapters.dtos.requests.FinancialRequestDto;
import com.dev.richardjd.financial.adapters.dtos.responses.FinancialResponseDto;

import java.util.List;
import java.util.Optional;

public interface IFinancialService {

    List<FinancialResponseDto> findAll();

    Optional<FinancialResponseDto> findById(Long id);

    Integer create(FinancialRequestDto request);

    Integer deleteById(Long id);
}
