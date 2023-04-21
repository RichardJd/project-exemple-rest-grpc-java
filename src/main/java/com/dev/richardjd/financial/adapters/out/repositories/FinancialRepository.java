package com.dev.richardjd.financial.adapters.out.repositories;

import com.dev.richardjd.financial.application.ports.out.repositories.IFinancialRepository;
import com.dev.richardjd.financial.domain.entities.FinancialEntity;
import com.dev.richardjd.financial.domain.valueobjects.CashFlowType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FinancialRepository implements IFinancialRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<FinancialEntity> findAll() {
        String sql = "SELECT * FROM financial";
        return this.jdbcTemplate.query(sql, (resultSet, rowNumber) ->
                FinancialEntity
                        .builder()
                        .id(resultSet.getLong(1))
                        .description(resultSet.getString(2))
                        .cashFlowType(CashFlowType.valueOf(resultSet.getString(3)))
                        .month(resultSet.getString(4))
                        .year(resultSet.getInt(5))
                        .amount(resultSet.getBigDecimal(6))
                        .build()
        );
    }

    @Override
    public FinancialEntity findById(Long id) {
        String sql = "SELECT * FROM financial WHERE id = ?";

        return this.jdbcTemplate.queryForObject(sql, (resultSet, rowNumber) ->
                FinancialEntity
                        .builder()
                        .id(resultSet.getLong(1))
                        .description(resultSet.getString(2))
                        .cashFlowType(CashFlowType.valueOf(resultSet.getString(3)))
                        .month(resultSet.getString(4))
                        .year(resultSet.getInt(5))
                        .amount(resultSet.getBigDecimal(6))
                        .build(), id);
    }

    @Override
    public Integer create(FinancialEntity financialEntity) {
        String sql = "INSERT INTO financial(description, cash_flow_type, month, year, amount) VALUES (?, ?, ?, ?, ?)";
        return this.jdbcTemplate.update(sql, financialEntity.getDescription(), financialEntity.getCashFlowType().name(),
                financialEntity.getMonth(), financialEntity.getYear(), financialEntity.getAmount());
    }

    @Override
    public Integer deleteById(Long id) {
        String sql = "DELETE FROM financial WHERE id = ?";
        return this.jdbcTemplate.update(sql, id);
    }
}
