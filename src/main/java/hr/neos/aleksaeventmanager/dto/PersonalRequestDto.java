package hr.neos.aleksaeventmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalRequestDto {

    private NameRequestDto name;
    private String email;
    private String phone;
    private EducationRequestDto education;
    private String summary;

}
