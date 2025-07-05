package ru.inno.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "operation")
@Getter
@Setter
@Builder
@ToString(exclude = "card")
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

    @Id
    private Long id;

    @Column(name = "operation_type")
    private String type;

    @Column(name = "balance_change")
    private BigDecimal balanceChange;

    @Column(name = "operation_date")
    private String date;

    private Boolean deleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", referencedColumnName = "id", nullable = false)
    private Card card;
}
