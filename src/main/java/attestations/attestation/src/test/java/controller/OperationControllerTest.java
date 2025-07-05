package controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import data.OperationData;
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
import ru.inno.controller.OperationController;
import ru.inno.service.OperationService;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OperationController.class)
@ContextConfiguration(classes = OperationController.class)
@AutoConfigureMockMvc
public class OperationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OperationService operationService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getOperation() throws Exception {
        var response = OperationData.getResponse();

        Mockito.when(operationService.getOperation(1L)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/operations/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getOperations() throws Exception {
        var response = List.of(OperationData.getResponse());

        Mockito.when(operationService.getOperations()).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/operations")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createOperation() throws Exception {
        var response = OperationData.getResponse();
        var request = OperationData.getRequest();

        Mockito.when(operationService.createOperation(request)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/operations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteOperation() throws Exception {
        Long id = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/operations/1"))
                .andDo(print())
                .andExpect(status().is(204));
    }

}
