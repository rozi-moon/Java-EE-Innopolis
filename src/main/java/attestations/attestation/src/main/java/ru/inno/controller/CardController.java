package ru.inno.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inno.dto.CardRequest;
import ru.inno.dto.CardResponse;
import ru.inno.service.CardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService service;

    @GetMapping("/{id}")
    public ResponseEntity<CardResponse> getCard(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCard(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CardResponse>> getCards() {
        return ResponseEntity.ok(service.getCards());
    }

    @PostMapping
    public ResponseEntity<CardResponse> createCard(@RequestBody CardRequest request) {
        return ResponseEntity.ok(service.createCard(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResponse> updateCard(@PathVariable Long id, @RequestBody CardRequest request) {
        return ResponseEntity.ok(service.updateCard(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        service.deleteCard(id);
        return ResponseEntity.noContent().build();
    }

}
