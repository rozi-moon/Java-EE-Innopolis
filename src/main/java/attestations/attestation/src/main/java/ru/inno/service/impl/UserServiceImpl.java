package ru.inno.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.dto.UserRequest;
import ru.inno.dto.UserResponse;
import ru.inno.exception.NotFoundException;
import ru.inno.mapper.UserMapper;
import ru.inno.model.User;
import ru.inno.repository.UserRepository;
import ru.inno.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponse getUser(Long id) {
        return repository.findById(id)
                .map(mapper::toUserResponse)
                .orElseThrow(() -> new NotFoundException("Пользователь с данным id = " + id + " не найден."));
    }

    @Override
    public List<UserResponse> getUsers() {
        return repository.findAll()
                .stream()
                .map(mapper::toUserResponse)
                .toList();
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User entity = mapper.toEntity(request);
        return mapper.toUserResponse(repository.save(entity));
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Пользователь с данным id = " + id + " не найден."));

        if (request.email() != null)
            entity.setEmail(request.email());

        if (request.login() != null)
            entity.setLogin(request.login());

        if (request.phoneNumber() != null)
            entity.setPhoneNumber(request.phoneNumber());

        if (request.password() != null)
            entity.setPassword(request.password());

        return mapper.toUserResponse(repository.save(entity));
    }

    @Override
    public void deleteUser(Long id) {
        User entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Пользователь с данным id = " + id + " не найден."));

        entity.setDeleted(true);
        repository.save(entity);
    }
}
