package ru.inno.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OperationResponse(Long id, String type, BigDecimal balanceChange, String date, Boolean deleted,
                                Long cardId) {
}