package uz.br29.card.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.br29.card.dto.request.CardAddRequest;
import uz.br29.card.dto.request.CardStatusRequest;
import uz.br29.card.dto.request.CardUpdateRequest;
import uz.br29.card.entity.Card;
import uz.br29.card.enums.CardStatus;
import uz.br29.card.repository.CardRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public ResponseEntity createCard(CardAddRequest request) {

        Card card = Card.builder()
                .cardNumber(generateCardNumber())
                .amount(request.getAmount())
                .ownerId(request.getOwnerId())
                .phoneNumber(request.getPhoneNumber())
                .status(CardStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .build();
        Card savedCard = cardRepository.save(card);
        return ResponseEntity.ok(savedCard);
    }

    private String generateCardNumber() {
        // Generate a 16-digit card number
        String cardNumber;
        do {
            cardNumber = String.format("%016d", Math.abs(UUID.randomUUID().getMostSignificantBits() % 10000000000000000L));
        } while (cardRepository.existsByCardNumber(cardNumber));
        return cardNumber;
    }

    public ResponseEntity getCardById(String id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found !"));
        return ResponseEntity.ok(card);
    }

    public ResponseEntity getAllCards() {
        List<Card> cardList = cardRepository.findAll();
        return ResponseEntity.ok(cardList);
    }

    public ResponseEntity getCardsByOwnerId(String ownerId) {
        List<Card> cardListByOwner = cardRepository.findAllByOwnerId(ownerId);
        return ResponseEntity.ok(cardListByOwner);
    }

    public ResponseEntity getCardsByPhoneNumber(String phoneNumber) {
        List<Card> cardListByPhoneNumber = cardRepository.findAllByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(cardListByPhoneNumber);
    }


    public ResponseEntity updateCard(String id, CardUpdateRequest request) {

        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found !"));
        card.setPhoneNumber(request.getPhoneNumber());
        card.setOwnerId(request.getOwnerId());
        Card updatedCard = cardRepository.save(card);
        return ResponseEntity.ok(updatedCard);

    }

    public ResponseEntity changeStatus(String id, CardStatusRequest request) {

        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found !"));
        card.setStatus(request.getStatus());
        Card updatedCard = cardRepository.save(card);
        return ResponseEntity.ok(updatedCard);

    }

    public ResponseEntity deleteCard(String id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found !"));
        cardRepository.delete(card);
        return ResponseEntity.noContent().build();
    }


}
