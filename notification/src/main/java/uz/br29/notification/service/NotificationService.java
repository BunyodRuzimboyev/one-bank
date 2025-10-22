package uz.br29.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.br29.notification.dto.request.NotificationCreateRequest;
import uz.br29.notification.entity.Notification;
import uz.br29.notification.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public ResponseEntity<?> createNotification(NotificationCreateRequest request) {
        Notification notification = Notification.builder()
                .message(request.getMessage())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .build();
        Notification savedNotification = notificationRepository.save(notification);
        return ResponseEntity.ok(savedNotification);
    }

    public ResponseEntity<?> getNotificationsByPhoneNumber(String phoneNumber) {

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("To account is required");
        }
        List<Notification> notificationListByPhoneNumber = notificationRepository.findAllByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(notificationListByPhoneNumber);
    }

}
