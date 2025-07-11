package controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import data.UserData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.inno.controller.UserController;
import ru.inno.service.UserService;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes = UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getUser() throws Exception {
        var response = UserData.getResponse();

        Mockito.when(userService.getUser(1L)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getUsers() throws Exception {
        var response = List.of(UserData.getResponse());

        Mockito.when(userService.getUsers()).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createUser() throws Exception {
        var response = UserData.getResponse();
        var request = UserData.getRequest();

        Mockito.when(userService.createUser(request)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateUser() throws Exception {
        Long id = 1L;
        var response = UserData.getResponse();
        var request = UserData.getRequest();

        Mockito.when(userService.updateUser(id, request)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteUser() throws Exception {
        Long id = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/users/1"))
                .andDo(print())
                .andExpect(status().is(204));
    }

}
