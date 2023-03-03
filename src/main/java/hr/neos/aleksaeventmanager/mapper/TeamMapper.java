package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.TeamRequestDto;
import hr.neos.aleksaeventmanager.entity.Team;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
        builder = @Builder(disableBuilder = true)
)
public interface TeamMapper {
    //Team toEntity(TeamRequestDto dto);
}
