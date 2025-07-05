package ru.inno.dto;

import java.math.BigDecimal;

public record OperationRequest(String type, BigDecimal balanceChange, String date, Long cardId) {
}