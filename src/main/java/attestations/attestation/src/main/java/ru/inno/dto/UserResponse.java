package ru.inno.dto;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String login, String password, String email, String phoneNumber, Boolean deleted) {
}