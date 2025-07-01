package ru.inno.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.inno.model.Card;
import ru.inno.model.Operation;
import ru.inno.repository.OperationRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class OperationRepositoryImpl implements OperationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Operation findById(Long id) {
        return jdbcTemplate.queryForObject("select * from operation where id = " + id, rowMapper());
    }

    @Override
    public List<Operation> findAll() {
        return jdbcTemplate.query("select * from operation", rowMapper());
    }

    @Override
    public Integer create(Operation operation) {
        return jdbcTemplate.update("INSERT INTO operation (operation_type, balance_change, operation_date, card_id) VALUES (?, ?, ?, ?)",
                operation.getType(), operation.getBalanceChange(), operation.getDate(), operation.getCardId());
    }

    @Override
    public Integer update(Operation operation) {
        return jdbcTemplate.update("UPDATE operation SET operation_type = ?, balance_change = ?, operation_date =?, card_id = ? WHERE id = ?",
                operation.getType(), operation.getBalanceChange(), operation.getDate(), operation.getCardId(), operation.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.execute("delete from operation where id = " + id);
    }

    @Override
    public void deleteAl() {
        jdbcTemplate.execute("delete from operation");
    }

    private RowMapper<Operation> rowMapper() {
        return (rs, rowNum) -> Operation.builder()
                .id(rs.getLong("id"))
                .type(rs.getString("operation_type"))
                .balanceChange(rs.getString("balance_change"))
                .date(rs.getString("operation_date"))
                .cardId(rs.getLong("card_id"))
                .build();
    }
}
