package uz.br29.notification.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.br29.notification.dto.request.NotificationCreateRequest;
import uz.br29.notification.service.NotificationService;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService service;
    private String message = "Notification message 😁😁😁";


    @PostMapping("/create")
    public ResponseEntity<?> createNotification(@Valid @RequestBody NotificationCreateRequest request) {
        return service.createNotification(request);
    }

    @GetMapping("/get/{phoneNumber}")
    public ResponseEntity<?> getNotificationsByPhoneNumber(@PathVariable String phoneNumber) {
        log.info("Get notifications by phone number = {}", phoneNumber);
        return service.getNotificationsByPhoneNumber(phoneNumber);
    }

    @GetMapping("/message")
    public String getMessage() {
        log.info("get message -> calling ...");
        return message;
    }

}
