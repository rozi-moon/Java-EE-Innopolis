package ru.inno.repository;

import ru.inno.model.User;

import java.util.List;

public interface UserRepository {

    User findById(Long id);

    List<User> findAll();

    Integer create(User operation);

    Integer update(User operation);

    void deleteById(Long id);

    void deleteAl();

}
