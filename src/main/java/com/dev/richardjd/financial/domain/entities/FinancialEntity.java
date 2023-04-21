package com.dev.richardjd.financial.domain.entities;

import com.dev.richardjd.financial.domain.valueobjects.CashFlowType;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Builder
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FinancialEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 6145619217761059045L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column(nullable = false)
    private final String description;

    @Column(nullable = false)
    private final String month;

    @Column(nullable = false)
    private final Integer year;

    @Enumerated(EnumType.STRING)
    @Column(name = "cash_flow_type", nullable = false)
    private final CashFlowType cashFlowType;

    @Column(nullable = false)
    private final BigDecimal amount;
}
