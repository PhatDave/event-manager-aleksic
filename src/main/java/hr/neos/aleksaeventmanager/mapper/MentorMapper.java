package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.MentorRequestDto;
import hr.neos.aleksaeventmanager.entity.Mentor;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
        builder = @Builder(disableBuilder = true)
)
public interface MentorMapper {
    Mentor toEntity(MentorRequestDto dto);
}
