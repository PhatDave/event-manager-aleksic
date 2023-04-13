package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.ExperienceRequestDto;
import hr.neos.aleksaeventmanager.dto.ExperienceResponseDto;
import hr.neos.aleksaeventmanager.entity.Experience;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
        builder = @Builder(disableBuilder = true)
)
public interface ExperienceMapper {

    Experience toEntity(ExperienceRequestDto dto);

    ExperienceResponseDto toDto(Experience experience);

    /*@AfterMapping
    default void mapExperienceIdInSkill(@MappingTarget Experience experience){

    }*/
}
