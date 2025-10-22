package uz.br29.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.br29.transaction.entity.Transaction;
import uz.br29.transaction.enums.TransactionStatusEnum;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findAllByFromCardId(String fromCardId);

    List<Transaction> findAllByToCardId(String toCardId);

    @Query(nativeQuery = true, value = "select * from transactions where to_card_id = :cardId or from_card_id = :cardId")
    List<Transaction> findAllByCardId(String cardId);

    List<Transaction> findAllByTransactionStatus(TransactionStatusEnum transactionStatus);

    List<Transaction> findAllByCreatedAtBetween(LocalDateTime createdAt, LocalDateTime createdAt2);
}
