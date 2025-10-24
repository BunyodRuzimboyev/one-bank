package uz.br29.profile.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.br29.profile.dto.card.CardDTO;

import java.util.List;

@FeignClient(name = "card")
public interface CardFeignClient {

    @GetMapping("/api/v1/card/phone/{phoneNumber}")
    ResponseEntity<List<CardDTO>> getCardsByPhoneNumber(@PathVariable String phoneNumber);
}
