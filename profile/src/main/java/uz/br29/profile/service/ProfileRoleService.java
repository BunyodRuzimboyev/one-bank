package uz.br29.profile.service;

import org.springframework.stereotype.Service;
import uz.br29.profile.entity.ProfileRole;
import uz.br29.profile.enums.RoleEnum;
import uz.br29.profile.repository.ProfileRoleRepository;

import java.util.List;

@Service
public class ProfileRoleService {

    private ProfileRoleRepository profileRoleRepository;

    public void create(String profileId, List<RoleEnum> roleList) {
        for (RoleEnum roleEnum : roleList) {
            ProfileRole entity = new ProfileRole();
            entity.setProfileId(profileId);
            entity.setRoles(roleEnum);
            profileRoleRepository.save(entity);
        }
    }

    public void merge(String profileId, List<RoleEnum> newList) {
        List<RoleEnum> oldList = profileRoleRepository.getRoleListByProfileId(profileId);
        newList.stream().filter(n -> !oldList.contains(n)).forEach(pe -> create(profileId, pe)); // create
        oldList.stream().filter(old -> !newList.contains(old)).forEach(pe -> delete(profileId, pe));
    }

    // old -> "ROLE_USER", "ROLE_ADMIN"
    // new -> "ROLE_USER", "ROLE_MODERATOR"
    public void create(String profileId, RoleEnum role) {
        ProfileRole entity = new ProfileRole();
        entity.setProfileId(profileId);
        entity.setRoles(role);
        profileRoleRepository.save(entity);
    }
    public void delete(String profileId, RoleEnum role) {
        profileRoleRepository.deleteByIdAndRoleEnum(profileId, role);
    }

    public void deleteRolesByProfileId(String profileId) {
        profileRoleRepository.deleteByProfileId(profileId);
    }

    public List<RoleEnum> getByProfileId(String id) {
        return profileRoleRepository.getRoleListByProfileId(id);
    }

}
