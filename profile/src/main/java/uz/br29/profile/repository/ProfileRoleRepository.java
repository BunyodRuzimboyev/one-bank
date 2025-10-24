package uz.br29.profile.repository;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import uz.br29.profile.entity.ProfileRoleEntity;
import uz.br29.profile.enums.ProfileRoleEnum;

import java.util.List;

public interface ProfileRoleRepository extends CrudRepository<ProfileRoleEntity, Integer> {

    @Query("select roles from ProfileRoleEntity where profileId =?1")
    List<ProfileRoleEnum> getRoleListByProfileId(String profileId);

    @Transactional
    @Modifying
    @Query("Delete from ProfileRoleEntity where profileId =?1 and roles =?2")
    void deleteByIdAndRoleEnum(String profileId, ProfileRoleEnum role);

    @Transactional
    @Modifying
    @Query("Delete from ProfileRoleEntity where profileId =?1")
    void deleteByProfileId(String profileId);
}
