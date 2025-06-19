package ru.inno.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "operation")
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", referencedColumnName = "id", nullable = false)
    private Card card;
}
