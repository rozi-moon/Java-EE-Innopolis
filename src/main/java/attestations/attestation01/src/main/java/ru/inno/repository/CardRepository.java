package ru.inno.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.inno.model.Card;
import ru.inno.model.User;

import java.util.List;

@RequiredArgsConstructor
public class CardRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Card> getCards() {
        return jdbcTemplate.queryForList("select * from users", Card.class);
    }

}
