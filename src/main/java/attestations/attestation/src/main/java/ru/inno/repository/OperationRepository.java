package ru.inno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.model.Card;
import ru.inno.model.Operation;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
