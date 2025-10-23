package uz.br29.profile.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.br29.profile.dto.request.ProfileCreateRequest;
import uz.br29.profile.dto.request.ProfileRegistrationRequest;
import uz.br29.profile.service.ProfileService;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private final ProfileService profileService;
    private String message = "Profile message";

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ProfileCreateRequest request) {
        return profileService.create(request);
    }

    @PostMapping("/registration") // bu api auth-service dan chaqiriladi.
    public ResponseEntity<Boolean> create2(@Valid @RequestBody ProfileRegistrationRequest request) {
        return profileService.create2(request);
    }

}
