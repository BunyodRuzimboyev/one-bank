package uz.br29.card.service;

import org.springframework.stereotype.Service;

@Service
public class CardMessageService {

    private String message = "CARD message";

    public String getMessage(){
        return message;
    }
}
