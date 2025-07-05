package ru.inno.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CardRequest(String cardNumber, LocalDate expireDate, BigDecimal balance, Long userId) {
}