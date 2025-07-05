package ru.inno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.model.Card;
import ru.inno.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
