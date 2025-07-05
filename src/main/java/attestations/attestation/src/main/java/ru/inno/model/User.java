package ru.inno.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@ToString(exclude = "cards")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String login;

    private String password;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private Boolean deleted = false;

    @OneToMany(mappedBy = "user")
    private List<Card> cards;

}
