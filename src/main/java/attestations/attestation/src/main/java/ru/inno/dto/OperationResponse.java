package ru.inno.dto;

import ru.inno.model.Operation;

import java.math.BigDecimal;

public record OperationResponse(Long id, String type, BigDecimal balanceChange, String date, Boolean deleted,
                                Long cardId) {
}