package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.ExperienceRequestDto;
import hr.neos.aleksaeventmanager.dto.ExperienceResponseDto;
import hr.neos.aleksaeventmanager.entity.Experience;
import hr.neos.aleksaeventmanager.entity.Skill;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        builder = @Builder(disableBuilder = true)
)
public interface ExperienceMapper {

    Experience toEntity(ExperienceRequestDto dto);

    ExperienceResponseDto toDto(Experience experience);

    @AfterMapping
    default void mapExperienceIdInSkill(@MappingTarget Experience experience) {
        List<Skill> skills = experience.getSkills();
        if (skills != null) {
            for (int i = 0; i < skills.size(); i++) {
                Skill skill = skills.get(i);
                skill.setExperience(experience);
            }
        }
    }
}
