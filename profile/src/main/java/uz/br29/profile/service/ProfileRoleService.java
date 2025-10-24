package uz.br29.profile.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.br29.profile.entity.ProfileRoleEntity;
import uz.br29.profile.enums.ProfileRoleEnum;
import uz.br29.profile.repository.ProfileRoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileRoleService {

    private final ProfileRoleRepository profileRoleRepository;

    public void create(String profileId, List<ProfileRoleEnum> roleList) {
        for (ProfileRoleEnum roleEnum : roleList) {
            ProfileRoleEntity entity = new ProfileRoleEntity();
            entity.setProfileId(profileId);
            entity.setRoles(roleEnum);
            profileRoleRepository.save(entity);
        }
    }

    public void merge(String profileId, List<ProfileRoleEnum> newList) {
        List<ProfileRoleEnum> oldList = profileRoleRepository.getRoleListByProfileId(profileId);
        newList.stream().filter(n -> !oldList.contains(n)).forEach(pe -> create(profileId, pe)); // create
        oldList.stream().filter(old -> !newList.contains(old)).forEach(pe -> profileRoleRepository.deleteByIdAndRoleEnum(profileId, pe));
    }

    // old -> "ROLE_USER", "ROLE_ADMIN"
    // new -> "ROLE_USER", "ROLE_MODERATOR"
    public void create(String profileId, ProfileRoleEnum role) {
        ProfileRoleEntity entity = new ProfileRoleEntity();
        entity.setProfileId(profileId);
        entity.setRoles(role);
        profileRoleRepository.save(entity);
    }

    public void deleteRolesByProfileId(String profileId) {
        profileRoleRepository.deleteByProfileId(profileId);
    }

    public List<ProfileRoleEnum> getByProfileId(String id) {
        return profileRoleRepository.getRoleListByProfileId(id);
    }
}
