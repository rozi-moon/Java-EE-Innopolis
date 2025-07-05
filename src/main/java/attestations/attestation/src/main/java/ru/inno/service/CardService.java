package ru.inno.service;

import ru.inno.dto.CardRequest;
import ru.inno.dto.CardResponse;

import java.util.List;

public interface CardService {

    CardResponse getCard(Long id);

    List<CardResponse> getCards();

    CardResponse createCard(CardRequest request);

    CardResponse updateCard(Long id, CardRequest request);

    void deleteCard(Long id);

}
