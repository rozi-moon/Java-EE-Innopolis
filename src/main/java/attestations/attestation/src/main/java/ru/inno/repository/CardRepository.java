package ru.inno.repository;

import ru.inno.model.Card;

import java.util.List;

public interface CardRepository {

    Card findById(Long id);

    List<Card> findAll();

    Integer create(Card operation);

    Integer update(Card operation);

    void deleteById(Long id);

    void deleteAl();

}
