package ru.inno.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.dto.CardRequest;
import ru.inno.dto.CardResponse;
import ru.inno.exception.NotFoundException;
import ru.inno.mapper.CardMapper;
import ru.inno.model.Card;
import ru.inno.repository.CardRepository;
import ru.inno.service.CardService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;
    private final CardMapper mapper;

    @Override
    public CardResponse getCard(Long id) {
        return repository.findById(id)
                .map(mapper::toCardResponse)
                .orElseThrow(() -> new NotFoundException("Карта с данным id = " + id + " не найдена."));
    }

    @Override
    public List<CardResponse> getCards() {
        return repository.findAll()
                .stream()
                .map(mapper::toCardResponse)
                .toList();
    }

    @Override
    public CardResponse createCard(CardRequest request) {
        Card entity = mapper.toEntity(request);
        return mapper.toCardResponse(repository.save(entity));
    }

    @Override
    public CardResponse updateCard(Long id, CardRequest request) {
        Card entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Карта с данным id = " + id + " не найдена."));

        if (request.cardNumber() != null)
            entity.setCardNumber(request.cardNumber());

        if (request.balance() != null)
            entity.setBalance(request.balance());

        if (request.expireDate() != null)
            entity.setExpireDate(request.expireDate());

        return mapper.toCardResponse(repository.save(entity));
    }

    @Override
    public void deleteCard(Long id) {
        Card entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Карта с данным id = " + id + " не найдена."));

        entity.setDeleted(true);
        repository.save(entity);
    }
}
