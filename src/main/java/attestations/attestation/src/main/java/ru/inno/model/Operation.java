package ru.inno.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "operation")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

    @Id
    private Long id;

    @Column(name = "operation_type")
    private String type;

    @Column(name = "balance_change")
    private String balanceChange;

    @Column(name = "operation_date")
    private String date;

    private Long cardId;
}
