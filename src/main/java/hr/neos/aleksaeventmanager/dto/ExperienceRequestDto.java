package hr.neos.aleksaeventmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceRequestDto {

    private Integer years;
    private List<SkillRequestDto> skills;
    private String repositoryUrl;
    private String summary;

}
