package ru.inno.dto;

public record UserResponse(Long id, String login, String password, String email, String phoneNumber, Boolean deleted) {
}