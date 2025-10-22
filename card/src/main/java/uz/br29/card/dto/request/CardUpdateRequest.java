package uz.br29.card.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardUpdateRequest {

    private String phoneNumber;
    private String ownerId;

}
