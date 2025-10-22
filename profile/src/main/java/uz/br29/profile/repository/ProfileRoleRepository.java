package uz.br29.profile.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.br29.profile.entity.ProfileRole;
import uz.br29.profile.enums.RoleEnum;

import java.util.List;

@Repository
public interface ProfileRoleRepository extends JpaRepository<ProfileRole, String> {

    @Query("select roles from ProfileRole where profileId =?1")
    List<RoleEnum> getRoleListByProfileId(String profileId);

    @Transactional
    @Modifying
    @Query("Delete from ProfileRole where profileId =?1 and roles =?2")
    void deleteByIdAndRoleEnum(String profileId, RoleEnum role);

    @Transactional
    @Modifying
    @Query("Delete from ProfileRole where profileId =?1")
    void deleteByProfileId(String profileId);
}
