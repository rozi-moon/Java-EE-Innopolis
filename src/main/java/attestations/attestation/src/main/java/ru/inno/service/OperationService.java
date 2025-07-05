package ru.inno.service;

import ru.inno.dto.OperationRequest;
import ru.inno.dto.OperationResponse;

import java.util.List;

public interface OperationService {

    OperationResponse getOperation(Long id);

    List<OperationResponse> getOperations();

    OperationResponse createOperation(OperationRequest request);

    void deleteOperation(Long id);

}
