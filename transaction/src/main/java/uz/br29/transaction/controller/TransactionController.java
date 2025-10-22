package uz.br29.transaction.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.br29.transaction.dto.request.TransactionCreateRequest;
import uz.br29.transaction.dto.request.TransactionStatusUpdateRequest;
import uz.br29.transaction.dto.request.TransactionUpdateRequest;
import uz.br29.transaction.enums.TransactionStatusEnum;
import uz.br29.transaction.service.TransactionService;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private String message = "Transaction message 😁😁😁";

    @PostMapping("/create")
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransactionCreateRequest request) {
        return transactionService.createTransaction(request);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable String id){
        log.info("get transaction by id -> {} ", id);
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/get/from-card/{fromCardId}")
    public ResponseEntity<?> getAllTransactionsByFromCard(@PathVariable String fromCardId) {
        return transactionService.getAllTransactionsByFromCard(fromCardId);
    }

    @GetMapping("/get/to-card/{toCardId}")
    public ResponseEntity<?> getAllTransactionsByToCard(@PathVariable String toCardId) {
        return transactionService.getAllTransactionsByToCard(toCardId);
    }

    @GetMapping("/get/card/{cardId}")
    public ResponseEntity<?> getAllByCardId(@PathVariable String cardId){
        return transactionService.getAllByCardId(cardId);
    }

    @GetMapping("/get/status/{status}")
    public ResponseEntity<?> getAllByStatus(@PathVariable TransactionStatusEnum status){
        return transactionService.getAllByStatus(status);
    }

    @GetMapping("/get/date-range")
    public ResponseEntity<?> getTransactionsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return transactionService.getTransactionsByDateRange(startDate, endDate);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable String id,
                                               @Valid @RequestBody TransactionUpdateRequest request) {
        return transactionService.updateTransaction(id, request);
    }

    @PatchMapping("/update/{id}/status")
    public ResponseEntity<?> updateTransactionStatus(@PathVariable String id,
                                                     @Valid @RequestBody TransactionStatusUpdateRequest request) {
        return transactionService.updateTransactionStatus(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTransactionById(@PathVariable String id) {
        return transactionService.deleteTransactionById(id);
    }

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }

}
