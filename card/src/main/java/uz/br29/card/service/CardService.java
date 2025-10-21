package uz.br29.card.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.br29.card.dto.request.CardAddRequest;
import uz.br29.card.repository.CardRepository;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public ResponseEntity createCard(CardAddRequest request) {
        return null;
    }

}
