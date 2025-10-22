package uz.br29.notification.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationCreateRequest {

    @NotBlank(message = "Message required")
    private String message;

    @NotBlank(message = "PhoneNumber required")
    private String phoneNumber;
}
