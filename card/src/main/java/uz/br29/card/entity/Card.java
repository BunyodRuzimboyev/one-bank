package uz.br29.card.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import uz.br29.card.enums.CardStatus;

import java.time.LocalDateTime;
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
    private String id;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "card_number", nullable = false, unique = true)
    private String cardNumber;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "owner_id",nullable = false)
    private String ownerId;

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @CreatedDate
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;

}
