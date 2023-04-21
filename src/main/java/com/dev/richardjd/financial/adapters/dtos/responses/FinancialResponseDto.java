package com.dev.richardjd.financial.adapters.dtos.responses;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

public record FinancialResponseDto(
        @EqualsAndHashCode.Include
        Long id,
        String description,
        String month,
        Integer year,
        String cashFlowType,
        BigDecimal amount
) {
}
