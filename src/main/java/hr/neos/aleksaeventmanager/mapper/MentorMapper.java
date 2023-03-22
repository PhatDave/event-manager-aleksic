package hr.neos.aleksaeventmanager.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
		builder = @Builder(disableBuilder = true)
)
public interface MentorMapper {
	//Mentor toEntity(MentorRequestDto dto);
}
