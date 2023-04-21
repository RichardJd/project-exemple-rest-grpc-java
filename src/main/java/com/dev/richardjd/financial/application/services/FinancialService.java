package com.dev.richardjd.financial.application.services;

import com.dev.richardjd.financial.adapters.dtos.requests.FinancialRequestDto;
import com.dev.richardjd.financial.adapters.dtos.responses.FinancialResponseDto;
import com.dev.richardjd.financial.adapters.mappers.FinancialMapper;
import com.dev.richardjd.financial.application.ports.in.services.IFinancialService;
import com.dev.richardjd.financial.application.ports.out.repositories.IFinancialRepository;
import com.dev.richardjd.financial.domain.entities.FinancialEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FinancialService implements IFinancialService {

    private final IFinancialRepository financialRepository;

    @Override
    public List<FinancialResponseDto> findAll() {
        List<FinancialEntity> financialEntityList = this.financialRepository.findAll();
        return FinancialMapper.fromEntityListToDtoResponseList(financialEntityList);
    }

    @Override
    public Optional<FinancialResponseDto> findById(Long id) {
        FinancialEntity financialEntity = this.financialRepository.findById(id);
        return Optional.of(FinancialMapper.fromEntityToDtoResponse(financialEntity));
    }

    @Override
    public Integer create(FinancialRequestDto financialRequestDto) {
        FinancialEntity financialEntity = FinancialMapper.fromDtoRequestToEntity(financialRequestDto);
        return this.financialRepository.create(financialEntity);
    }

    @Override
    public Integer deleteById(Long id) {
        return this.financialRepository.deleteById(id);
    }
}
