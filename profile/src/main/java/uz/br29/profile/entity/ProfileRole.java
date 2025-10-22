package uz.br29.profile.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.br29.profile.enums.RoleEnum;

@Entity
@Table(name = "_profile_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRole {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "profile_id")
    private String profileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", insertable = false, updatable = false, nullable = false)
    private Profile profile;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private RoleEnum roles;

}
