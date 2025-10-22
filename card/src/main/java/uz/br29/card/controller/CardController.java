package uz.br29.card.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.br29.card.dto.request.CardAddRequest;
import uz.br29.card.dto.request.CardStatusRequest;
import uz.br29.card.dto.request.CardUpdateRequest;
import uz.br29.card.service.CardMessageService;
import uz.br29.card.service.CardService;

@RestController
@RequestMapping("api/v1/card")
@RequiredArgsConstructor
@Slf4j
public class CardController {

    private final CardService cardService;
    private final CardMessageService cardMessageService;


    @PostMapping("/create")
    public ResponseEntity<?> createCard(@Valid @RequestBody CardAddRequest request) {
        return cardService.createCard(request);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCardById(@PathVariable String id) {
        log.info("get card by id -> {} ", id);
        return cardService.getCardById(id);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/get/owner/{ownerId}")
    public ResponseEntity<?> getCardsByOwnerId(@PathVariable String ownerId) {
        return cardService.getCardsByOwnerId(ownerId);
    }

    @GetMapping("/get/phone/{phoneNumber}")
    public ResponseEntity<?> getCardsByPhoneNumber(@PathVariable String phoneNumber) {
        return cardService.getCardsByPhoneNumber(phoneNumber);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCard(@PathVariable String id,
                                     @Valid @RequestBody CardUpdateRequest request) {
        return cardService.updateCard(id, request);
    }

    @PatchMapping("/change/{id}/status")
    public ResponseEntity<?> changeCardStatus(@PathVariable String id, @Valid @RequestBody CardStatusRequest request){
        return cardService.changeStatus(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable String id) {
        return cardService.deleteCard(id);
    }

    @GetMapping("/message")
    public String message(){
        return cardMessageService.getMessage();
    }


}
