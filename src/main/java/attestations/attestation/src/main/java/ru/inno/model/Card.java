package ru.inno.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "card")
@Getter
@Setter
@Builder
@ToString(exclude = {"user", "operations"})
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    private BigDecimal balance;

    private Boolean deleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "card")
    private List<Operation> operations;

}
