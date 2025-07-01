package ru.inno.repository;

import ru.inno.model.Operation;

import java.util.List;

public interface OperationRepository {

    Operation findById(Long id);

    List<Operation> findAll();

    Integer create(Operation operation);

    Integer update(Operation operation);

    void deleteById(Long id);

    void deleteAl();

}
