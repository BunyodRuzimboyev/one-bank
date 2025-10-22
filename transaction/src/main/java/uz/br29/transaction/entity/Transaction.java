package uz.br29.transaction.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import uz.br29.transaction.enums.TransactionStatusEnum;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "from_card_id", nullable = false)
    private String fromCardId;

    @Column(name = "to_card_id", nullable = false)
    private String toCardId;

    @Column(name = "amount")
    private Double amount = 0.0;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status")
    private TransactionStatusEnum transactionStatus;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
