package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.PersonalRequestDto;
import hr.neos.aleksaeventmanager.dto.PersonalResponseDto;
import hr.neos.aleksaeventmanager.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        uses = {
                EducationMapper.class
        },
        builder = @Builder(disableBuilder = true)
)
public interface PersonalMapper {

    @Mapping(source = "name.first", target = "personalInfo.firstName")
    @Mapping(source = "name.last", target = "personalInfo.lastName")
    @Mapping(source = "email", target = "personalInfo.email")
    @Mapping(source = "phone", target = "personalInfo.phone")
    @Mapping(source = "summary", target = "otherUserInfo.summary")
    User toEntity(PersonalRequestDto dto);

    @Mapping(source = "personalInfo.firstName", target = "name.first")
    @Mapping(source = "personalInfo.lastName", target = "name.last")
    @Mapping(source = "personalInfo.email", target = "email")
    @Mapping(source = "personalInfo.phone", target = "phone")
    @Mapping(source = "otherUserInfo.summary", target = "summary")
    PersonalResponseDto toDto(User user);

}
