package uz.br29.profile.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uz.br29.profile.dto.request.ProfileCreateRequest;
import uz.br29.profile.entity.Profile;
import uz.br29.profile.enums.ProfileStatus;
import uz.br29.profile.exceptions.AppBadException;
import uz.br29.profile.repository.ProfileRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileRoleService profileRoleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> create(ProfileCreateRequest request) {
        Optional<Profile> optional = profileRepository.findByPhoneNumberAndVisibleIsTrue(request.getPhoneNumber());
        if (optional.isPresent()) {
            throw new AppBadException("User exists");
        }
        Profile entity = new Profile();
        entity.setName(request.getName());
        entity.setSurname(request.getSurname());

        entity.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setVisible(Boolean.TRUE);
        profileRepository.save(entity); // save
        // role_save
        profileRoleService.merge(entity.getId(), request.getRoleList());


        return null;
    }
}
