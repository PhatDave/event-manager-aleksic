package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationResponseDto;
import hr.neos.aleksaeventmanager.entity.Registration;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
        /*uses = {

        },*/
        builder = @Builder(disableBuilder = true)
)
public abstract class RegistrationMapper {

    public abstract Registration toEntity(RegistrationRequestDto dto);

    public abstract RegistrationResponseDto toDto(Registration registration);
}
