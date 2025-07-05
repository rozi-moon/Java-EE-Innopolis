package ru.inno.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.inno.dto.OperationRequest;
import ru.inno.dto.OperationResponse;
import ru.inno.service.OperationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/operations")
public class OperationController {

    private final OperationService service;

    @GetMapping("/{id}")
    public ResponseEntity<OperationResponse> getOperation(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOperation(id));
    }

    @GetMapping()
    public ResponseEntity<List<OperationResponse>> getOperations() {
        return ResponseEntity.ok(service.getOperations());
    }

    @PostMapping
    public ResponseEntity<OperationResponse> createOperation(@RequestBody OperationRequest request) {
        return ResponseEntity.ok(service.createOperation(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperation(@PathVariable Long id) {
        service.deleteOperation(id);
        return ResponseEntity.noContent().build();
    }

}
