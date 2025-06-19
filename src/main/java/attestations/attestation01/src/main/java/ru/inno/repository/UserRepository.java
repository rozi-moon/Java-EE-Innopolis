package ru.inno.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.inno.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<User> getUsers() {
        return jdbcTemplate.queryForList("select * from users", User.class);
    }

}
