package ru.inno.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.inno.dto.OperationRequest;
import ru.inno.dto.OperationResponse;
import ru.inno.model.Operation;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OperationMapper {

    @Mapping(source = "cardId", target = "card.id")
    Operation toEntity(OperationResponse operationResponse);

    @Mapping(source = "card.id", target = "cardId")
    OperationResponse toOperationResponse(Operation operation);

    @Mapping(source = "cardId", target = "card.id")
    Operation toEntity(OperationRequest operationRequest);

    @Mapping(source = "card.id", target = "cardId")
    OperationRequest toOperationRequest(Operation operation);
}