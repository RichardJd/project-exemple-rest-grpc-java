package com.dev.richardjd.financial.adapters.dtos.requests;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public record FinancialRequestDto(
        @NotBlank
        @Size(max = 255)
        String description,

        @NotBlank
        @Size(min = 1, max = 10)
        String month,

        @NotNull
        @Max(9999)
        Integer year,

        @NotBlank
        @Size(min = 1, max = 15)
        String cashFlowType,

        @Digits(integer = 6, fraction = 2)
        @DecimalMin(value = "0.0")
        BigDecimal amount
) {
}
