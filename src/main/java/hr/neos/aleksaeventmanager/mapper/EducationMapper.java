package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.EducationRequestDto;
import hr.neos.aleksaeventmanager.dto.EducationResponseDto;
import hr.neos.aleksaeventmanager.entity.Education;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface EducationMapper {

    Education toEntity(EducationRequestDto dto);

    //EducationResponseDto toDto(Education dto);
    //EducationResponseDto toDto(Education education);
}
