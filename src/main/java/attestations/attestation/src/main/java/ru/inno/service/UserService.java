package ru.inno.service;

import ru.inno.dto.UserRequest;
import ru.inno.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse getUser(Long id);

    List<UserResponse> getUsers();

    UserResponse createUser(UserRequest request);

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);

}
