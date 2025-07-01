package ru.inno.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.inno.model.Card;
import ru.inno.model.Operation;
import ru.inno.model.User;
import ru.inno.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject("select * from users where id = " + id, rowMapper());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", rowMapper());
    }

    @Override
    public Integer create(User entity) {
        return jdbcTemplate.update("INSERT INTO users (login, password, email, phone_number) VALUES (?, ?, ?, ?)",
                entity.getLogin(), entity.getPassword(), entity.getEmail(), entity.getPhoneNumber());
    }

    @Override
    public Integer update(User entity) {
        return jdbcTemplate.update("UPDATE users SET login = ?, password = ?, email = ?, phone_number = ? WHERE id = ?",
                entity.getLogin(), entity.getPassword(), entity.getEmail(), entity.getPhoneNumber(), entity.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.execute("delete from users where id = " + id);
    }

    @Override
    public void deleteAl() {
        jdbcTemplate.execute("delete from users");
    }

    private RowMapper<User> rowMapper() {
        return (rs, rowNum) -> User.builder()
                .id(rs.getLong("id"))
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .email(rs.getString("email"))
                .phoneNumber(rs.getString("phone_number"))
                .build();
    }
}
