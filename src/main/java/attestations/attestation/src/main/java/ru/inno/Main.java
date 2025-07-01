package ru.inno;

import ru.inno.config.JdbcTemplateConfig;
import ru.inno.model.User;
import ru.inno.repository.CardRepository;
import ru.inno.repository.OperationRepository;
import ru.inno.repository.UserRepository;
import ru.inno.repository.impl.CardRepositoryImpl;
import ru.inno.repository.impl.OperationRepositoryImpl;
import ru.inno.repository.impl.UserRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CardRepository cardRepository = new CardRepositoryImpl(JdbcTemplateConfig.jdbcTemplate());
        OperationRepository operationRepository = new OperationRepositoryImpl(JdbcTemplateConfig.jdbcTemplate());
        UserRepository userRepository = new UserRepositoryImpl(JdbcTemplateConfig.jdbcTemplate());

        User userOne = User.builder()
                .login("someLogin")
                .email("someEmail")
                .phoneNumber("89991231234")
                .password("password")
                .build();

        userRepository.create(userOne);
        List<User> userList = userRepository.findAll();
        System.out.println(userList);

        var operationList = operationRepository.findAll();
        System.out.println(operationList);

        var cardList = cardRepository.findAll();
        System.out.println(cardList);

        userRepository.deleteById(15L);

        User userEntity = userRepository.findById(1L);
        userEntity.setLogin("newLogin123");
        userRepository.update(userEntity);

    }
}