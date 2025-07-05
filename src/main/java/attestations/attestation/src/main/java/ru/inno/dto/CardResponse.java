package ru.inno.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CardResponse(Long id, String cardNumber, LocalDate expireDate, BigDecimal balance, Boolean deleted, Long userId) {
}