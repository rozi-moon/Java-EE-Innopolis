package ru.inno.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.inno.dto.CardRequest;
import ru.inno.dto.CardResponse;
import ru.inno.model.Card;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper {
    @Mapping(source = "userId", target = "user.id")
    Card toEntity(CardResponse cardResponse);

    @Mapping(source = "user.id", target = "userId")
    CardResponse toCardResponse(Card card);

    @Mapping(source = "userId", target = "user.id")
    Card toEntity(CardRequest cardRequest);

    @Mapping(source = "user.id", target = "userId")
    CardRequest toCardRequest(Card card);
}