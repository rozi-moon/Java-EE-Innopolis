package ru.inno.dto;

import lombok.Builder;

@Builder
public record UserRequest(String login, String password, String email, String phoneNumber) {
}