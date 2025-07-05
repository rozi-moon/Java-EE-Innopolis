package data;

import ru.inno.dto.OperationRequest;
import ru.inno.dto.OperationResponse;
import ru.inno.model.Operation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OperationData {

    public static OperationRequest getRequest() {
        return OperationRequest.builder()
                .type("INCOME")
                .date(LocalDate.of(2025, 05, 10).toString())
                .cardId(1L)
                .balanceChange(BigDecimal.valueOf(1000L))
                .build();
    }

    public static Operation getUserEntity() {
        return Operation.builder()
                .id(1L)
                .type("INCOME")
                .date(LocalDate.of(2025, 05, 10).toString())
                .balanceChange(BigDecimal.valueOf(1000L))
                .deleted(false)
                .build();
    }

    public static OperationResponse getResponse() {
        return OperationResponse.builder()
                .id(1L)
                .type("INCOME")
                .date(LocalDate.of(2025, 05, 10).toString())
                .cardId(1L)
                .balanceChange(BigDecimal.valueOf(1000L))
                .deleted(false)
                .build();
    }

}
