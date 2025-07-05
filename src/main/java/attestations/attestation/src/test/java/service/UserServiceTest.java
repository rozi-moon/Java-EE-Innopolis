package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import ru.inno.dto.UserRequest;
import ru.inno.mapper.UserMapper;
import ru.inno.mapper.UserMapperImpl;
import ru.inno.model.User;
import ru.inno.repository.UserRepository;
import ru.inno.service.UserService;
import ru.inno.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;


@SpringBootTest(classes = {UserServiceImpl.class, UserMapperImpl.class})
public class UserServiceTest {

    @Autowired
    private UserService service;
    @Autowired
    private UserMapper mapper;
    @MockitoBean
    private UserRepository repository;

    @Test
    void getUser() {
        Long id = 1L;
        User entity = getUserEntity();

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(entity));

        var response = service.getUser(id);

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(response);
            Assertions.assertEquals(entity.getId(), response.id());
            Assertions.assertEquals(entity.getLogin(), response.login());
        });
    }

    @Test
    void getUsers() {
        List<User> entities = List.of(getUserEntity());

        Mockito.when(repository.findAll()).thenReturn(entities);

        var response = service.getUsers();

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(response);
            Assertions.assertEquals(entities.size(), response.size());
        });
    }

    @Test
    void createUser() {
        UserRequest request = getRequest();
        User entity = getUserEntity();

        Mockito.when(repository.save(Mockito.any(User.class))).thenReturn(entity);

        var response = service.createUser(request);

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(response);
        });
    }

    @Test
    void updateUser() {
        Long id = 1L;
        UserRequest request = getRequest();
        User entity = getUserEntity();

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(entity));
        Mockito.when(repository.save(Mockito.any(User.class))).thenReturn(entity);

        var response = service.updateUser(id, request);

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(response);
        });
    }

    @Test
    void deleteUser() {
        Long id = 1L;
        User entity = getUserEntity();

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(entity));

        Assertions.assertDoesNotThrow(() -> service.deleteUser(id));
    }

    private static UserRequest getRequest() {
        return UserRequest.builder()
                .email("email")
                .login("login")
                .password("password")
                .phoneNumber("89991231234")
                .build();
    }

    private static User getUserEntity() {
        return User.builder()
                .id(1L)
                .login("login")
                .password("password")
                .email("email")
                .phoneNumber("89991231234")
                .build();
    }

}
