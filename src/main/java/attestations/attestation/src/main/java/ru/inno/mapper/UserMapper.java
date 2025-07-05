package ru.inno.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.inno.dto.UserRequest;
import ru.inno.dto.UserResponse;
import ru.inno.model.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserResponse userResponse);

    UserResponse toUserResponse(User user);

    User toEntity(UserRequest userRequest);

    UserRequest toUserRequest(User user);
}