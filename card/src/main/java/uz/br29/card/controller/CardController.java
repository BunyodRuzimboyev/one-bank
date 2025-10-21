package uz.br29.card.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.br29.card.dto.request.CardAddRequest;
import uz.br29.card.service.CardService;

@RestController
@RequestMapping("api/v1/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;


    @PostMapping("/create")
    public ResponseEntity createCard(@RequestBody CardAddRequest request){
        return cardService.createCard(request);
    }

}
