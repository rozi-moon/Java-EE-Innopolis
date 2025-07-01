package ru.inno.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.inno.model.Card;
import ru.inno.model.Operation;
import ru.inno.repository.CardRepository;

import java.util.List;

@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Card findById(Long id) {
        return jdbcTemplate.queryForObject("select * from card where id = " + id, rowMapper());
    }

    @Override
    public List<Card> findAll() {
        return jdbcTemplate.query("select * from card", rowMapper());
    }

    @Override
    public Integer create(Card entity) {
        return jdbcTemplate.update("INSERT INTO card (card_number, expire_date, balance, user_id) VALUES (?, ?, ?, ?)",
                entity.getCardNumber(), entity.getExpireDate(), entity.getBalance(), entity.getUserId());
    }

    @Override
    public Integer update(Card entity) {
        return jdbcTemplate.update("UPDATE card SET card_number = ?, expire_date = ?, balance = ?, user_id = ? where id = ?)",
                entity.getCardNumber(), entity.getExpireDate(), entity.getBalance(), entity.getUserId(), entity.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.execute("delete from card where id = " + id);
    }

    @Override
    public void deleteAl() {
        jdbcTemplate.execute("delete from card");
    }

    private RowMapper<Card> rowMapper() {
        return (rs, rowNum) -> Card.builder()
                .id(rs.getLong("id"))
                .cardNumber(rs.getString("card_number"))
                .expireDate(rs.getDate("expire_date").toLocalDate())
                .balance(rs.getBigDecimal("balance"))
                .userId(rs.getLong("user_id"))
                .build();
    }
}
