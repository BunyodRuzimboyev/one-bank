package uz.br29.profile.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import uz.br29.profile.enums.ProfileStatus;
import uz.br29.profile.enums.RoleEnum;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileCreateRequest {

    private String id;

    @NotBlank(message = "Ism bo‘sh bo‘lmasligi kerak")
    private String name;

    @NotBlank(message = "Familiya bo‘sh bo‘lmasligi kerak")
    private String surname;

    @NotBlank(message = "PhoneNumber bo‘sh bo‘lmasligi kerak")
    private String phoneNumber;

    @NotBlank(message = "Parol bo‘sh bo‘lmasligi kerak")
    private String password;

    @NotEmpty(message = "Role bo‘sh bo‘lmasligi kerak")
    private List<RoleEnum> roleList;

    private LocalDateTime createdDate;
    private ProfileStatus status;
    private String jwt;

}
