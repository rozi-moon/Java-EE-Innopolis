package data;

import ru.inno.dto.UserRequest;
import ru.inno.dto.UserResponse;
import ru.inno.model.User;

public class UserData {

    public static UserRequest getRequest() {
        return UserRequest.builder()
                .email("email")
                .login("login")
                .password("password")
                .phoneNumber("89991231234")
                .build();
    }

    public static User getUserEntity() {
        return User.builder()
                .id(1L)
                .login("login")
                .password("password")
                .email("email")
                .phoneNumber("89991231234")
                .build();
    }

    public static UserResponse getResponse() {
        return UserResponse.builder()
                .id(1L)
                .login("login")
                .password("password")
                .email("email")
                .phoneNumber("89991231234")
                .deleted(false)
                .build();
    }

}
