package com.dev.richardjd.financial.adapters.mappers;

import com.dev.richardjd.financial.adapters.dtos.requests.FinancialRequestDto;
import com.dev.richardjd.financial.adapters.dtos.responses.FinancialResponseDto;
import com.dev.richardjd.financial.domain.entities.FinancialEntity;
import com.dev.richardjd.financial.domain.valueobjects.CashFlowType;

import java.util.List;
import java.util.stream.Collectors;

public final class FinancialMapper {

    public static FinancialResponseDto fromEntityToDtoResponse(FinancialEntity financialEntity) {
        return new FinancialResponseDto(
                financialEntity.getId(),
                financialEntity.getDescription(),
                financialEntity.getMonth(),
                financialEntity.getYear(),
                financialEntity.getCashFlowType().name(),
                financialEntity.getAmount()
        );
    }

    public static List<FinancialResponseDto> fromEntityListToDtoResponseList(List<FinancialEntity> financialEntityList) {
        return financialEntityList.stream().map(
                        FinancialMapper::fromEntityToDtoResponse)
                .collect(Collectors.toList());
    }

    public static FinancialEntity fromDtoRequestToEntity(FinancialRequestDto financialRequestDto) {
        return FinancialEntity
                .builder()
                .description(financialRequestDto.description())
                .cashFlowType(CashFlowType.valueOf(financialRequestDto.cashFlowType()))
                .month(financialRequestDto.month())
                .year(financialRequestDto.year())
                .amount(financialRequestDto.amount())
                .build();
    }
}
