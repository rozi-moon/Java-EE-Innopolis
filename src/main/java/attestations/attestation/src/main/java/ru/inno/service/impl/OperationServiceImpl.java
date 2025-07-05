package ru.inno.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.dto.OperationRequest;
import ru.inno.dto.OperationResponse;
import ru.inno.exception.NotFoundException;
import ru.inno.mapper.OperationMapper;
import ru.inno.model.Operation;
import ru.inno.repository.OperationRepository;
import ru.inno.service.OperationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final OperationRepository repository;
    private final OperationMapper mapper;

    @Override
    public OperationResponse getOperation(Long id) {
        return repository.findById(id)
                .map(mapper::toOperationResponse)
                .orElseThrow(() -> new NotFoundException("Операция с данным id = " + id + " не найдена."));
    }

    @Override
    public List<OperationResponse> getOperations() {
        return repository.findAll()
                .stream()
                .map(mapper::toOperationResponse)
                .toList();
    }

    @Override
    public OperationResponse createOperation(OperationRequest request) {
        Operation entity = mapper.toEntity(request);
        return mapper.toOperationResponse(repository.save(entity));
    }

    @Override
    public void deleteOperation(Long id) {
        Operation entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Операция с данным id = " + id + " не найдена."));

        entity.setDeleted(true);
        repository.save(entity);
    }
}
