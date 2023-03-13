package hr.neos.aleksaeventmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDto {

    private PersonalRequestDto personal;
    private ExperienceRequestDto experience;
    private String motivation;
    private String preferredOS;

}
