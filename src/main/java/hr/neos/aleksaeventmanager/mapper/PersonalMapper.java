package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.PersonalRequestDto;
import hr.neos.aleksaeventmanager.dto.PersonalResponseDto;
import hr.neos.aleksaeventmanager.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
		builder = @Builder(disableBuilder = true)
)
public interface PersonalMapper {

	User toEntity(PersonalRequestDto dto);

	PersonalResponseDto toDto(User user);
}
