package uz.br29.profile.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import uz.br29.profile.enums.ProfileStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "_profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProfileStatus status;

    @Column(name = "photo_id")
    private String photoId;

    @Column(name = "visible")
    private Boolean visible;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "profile")
    private List<ProfileRole> roleList;

}
