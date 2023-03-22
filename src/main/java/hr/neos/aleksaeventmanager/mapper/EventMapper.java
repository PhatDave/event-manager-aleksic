package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.dto.EventResponseDto;
import hr.neos.aleksaeventmanager.entity.Event;
import hr.neos.aleksaeventmanager.entity.Team;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(
		uses = {
				TeamMapper.class
		},
		builder = @Builder(disableBuilder = true)
)
public interface EventMapper {

	Event toEntity(EventRequestDto dto);

	EventResponseDto toDto(Event event);

	@AfterMapping
	default void mapEventIdInTeam(@MappingTarget Event event) {
		List<Team> teams = event.getTeams();
		if (teams != null) {
			for (int i = 0; i < teams.size(); i++) {
				Team team = teams.get(i);
				if (team != null) {
					team.setEvent(event);
				}
			}
		}
	}

}
