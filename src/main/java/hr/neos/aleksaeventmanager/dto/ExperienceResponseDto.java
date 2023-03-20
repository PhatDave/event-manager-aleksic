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
public class ExperienceResponseDto {

    private Integer years;
    private List<SkillResponseDto> skills;
    private String repositoryUrl;
    private String summary;

}
