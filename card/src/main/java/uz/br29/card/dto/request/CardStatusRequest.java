package uz.br29.card.dto.request;

import lombok.Getter;
import lombok.Setter;
import uz.br29.card.enums.CardStatus;

@Getter
@Setter
public class CardStatusRequest {
    private CardStatus status;
}
