package ru.inno.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OperationRequest(String type, BigDecimal balanceChange, String date, Long cardId) {
}