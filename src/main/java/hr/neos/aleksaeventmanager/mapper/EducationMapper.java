package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.EducationRequestDto;
import hr.neos.aleksaeventmanager.dto.EducationResponseDto;
import hr.neos.aleksaeventmanager.entity.Education;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface EducationMapper {

    //@Mapping(source = "year", target = "years")
    Education toEntity(EducationRequestDto dto);

    //EducationResponseDto toDto(Education dto);
    //@Mapping(source = "years", target = "year")
    EducationResponseDto toDto(Education education);


}
