package uz.br29.card.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.br29.card.enums.CardStatus;

import java.util.UUID;

@Entity
@Table(name = "_card")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    private Double amount;

    @Column(nullable = false)
    private UUID ownerId;

    @Enumerated(EnumType.STRING)
    private CardStatus status;
}
