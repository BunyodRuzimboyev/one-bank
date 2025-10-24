package uz.br29.profile.dto;


import lombok.Getter;
import lombok.Setter;
import uz.br29.profile.enums.ProfileRoleEnum;

import java.time.LocalDate;

@Getter
@Setter
public class ProfileFilterDTO {
    private String query; // name, surname, username
    private ProfileRoleEnum role;
    private LocalDate createdDateFrom;
    private LocalDate createdDateTo;
}
