package ru.inno.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.inno.model.Operation;
import ru.inno.model.User;

import java.util.List;

@RequiredArgsConstructor
public class OperationRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Operation> getOperations() {
        return jdbcTemplate.queryForList("select * from users", Operation.class);
    }

}
