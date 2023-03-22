package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.PersonalRequestDto;
import hr.neos.aleksaeventmanager.dto.PersonalResponseDto;
import hr.neos.aleksaeventmanager.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
        /*uses = {

        },*/
        builder = @Builder(disableBuilder = true)
)
public interface PersonalMapper {

        User toEntity(PersonalRequestDto dto);

        PersonalResponseDto toDto(User user);

        /*@AfterMapping
        default void mapUserIdInExperience(@MappingTarget User user){

        }*/
}
