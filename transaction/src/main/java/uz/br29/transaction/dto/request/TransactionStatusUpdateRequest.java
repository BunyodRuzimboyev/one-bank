package uz.br29.transaction.dto.request;

import lombok.Getter;
import lombok.Setter;
import uz.br29.transaction.enums.TransactionStatusEnum;

@Getter
@Setter
public class TransactionStatusUpdateRequest {
    private TransactionStatusEnum status;
}
