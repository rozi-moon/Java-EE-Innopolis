package ru.inno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.model.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

}
