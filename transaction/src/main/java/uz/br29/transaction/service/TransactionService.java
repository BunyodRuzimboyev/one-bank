package uz.br29.transaction.service;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.br29.transaction.dto.request.TransactionCreateRequest;
import uz.br29.transaction.dto.request.TransactionStatusUpdateRequest;
import uz.br29.transaction.dto.request.TransactionUpdateRequest;
import uz.br29.transaction.entity.Transaction;
import uz.br29.transaction.enums.TransactionStatusEnum;
import uz.br29.transaction.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public ResponseEntity<?> createTransaction(TransactionCreateRequest request) {

        if (request.getToCardId().equals(request.getFromCardId())) {
            throw new IllegalArgumentException("From card and to card is the same");
        }

        if (request.getAmount() == null || request.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        Transaction transaction = Transaction.builder()
                .fromCardId(request.getFromCardId())
                .toCardId(request.getToCardId())
                .amount(request.getAmount())
                .transactionStatus(TransactionStatusEnum.SUCCESS)
                .createdAt(LocalDateTime.now())
                .build();

        Transaction savedTransaction = transactionRepository.save(transaction);
        return ResponseEntity.ok(savedTransaction);

    }

    public ResponseEntity<?> getTransactionById(String id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new NotFoundException("Tranzaksiya topilmadi"));
        return ResponseEntity.ok(transaction);
    }

    public ResponseEntity<?> getAllTransactions() {
        List<Transaction> transactionList = transactionRepository.findAll();
        return ResponseEntity.ok(transactionList);
    }

    public ResponseEntity<?> getAllTransactionsByFromCard(String fromCardId) {
        List<Transaction> transactionListByFromCard = transactionRepository.findAllByFromCardId(fromCardId);
        return ResponseEntity.ok(transactionListByFromCard);
    }

    public ResponseEntity<?> getAllTransactionsByToCard(String toCardId) {
        List<Transaction> transactionListByToCard = transactionRepository.findAllByToCardId(toCardId);
        return ResponseEntity.ok(transactionListByToCard);
    }

    public ResponseEntity<?> getAllByCardId(String cardId) {
        List<Transaction> transactionListByCardId = transactionRepository.findAllByCardId(cardId);
        return ResponseEntity.ok(transactionListByCardId);
    }

    public ResponseEntity<?> getAllByStatus(TransactionStatusEnum status) {
        List<Transaction> transactionListByStatus = transactionRepository.findAllByTransactionStatus(status);
        return ResponseEntity.ok(transactionListByStatus);
    }

    public ResponseEntity<?> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Transaction> transactionList = transactionRepository.findAllByCreatedAtBetween(startDate, endDate);
        return ResponseEntity.ok(transactionList);
    }

    public ResponseEntity<?> updateTransaction(String id, TransactionUpdateRequest request) {

        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new NotFoundException("Transaction not found"));

        if (request.getFromCardId().equals(request.getToCardId())) {
            throw new IllegalArgumentException("From card and to card cannot be the same");
        }

        // Validate amount
        if (request.getAmount() == null || request.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        transaction.setFromCardId(request.getFromCardId());
        transaction.setToCardId(request.getToCardId());
        transaction.setAmount(request.getAmount());
        Transaction updatedTransaction = transactionRepository.save(transaction);

        return ResponseEntity.ok(updatedTransaction);

    }

    public ResponseEntity<?> updateTransactionStatus(String id, TransactionStatusUpdateRequest request) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new NotFoundException("Transaction not found"));
        transaction.setTransactionStatus(request.getStatus());
        Transaction updatedTransactionWithStatus = transactionRepository.save(transaction);
        return ResponseEntity.ok(updatedTransactionWithStatus);
    }

    public ResponseEntity<?> deleteTransactionById(String id) {
        try {
            transactionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}