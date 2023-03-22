package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.entity.Mentor;
import hr.neos.aleksaeventmanager.entity.Team;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(
		uses = {
				MentorMapper.class,
		},
		builder = @Builder(disableBuilder = true)
)
public interface TeamMapper {

	@AfterMapping
	default void mapTeamIdInMentor(@MappingTarget Team team) {
		List<Mentor> mentors = team.getMentors();
		if (mentors != null) {
			for (int i = 0; i < mentors.size(); i++) {
				Mentor mentor = mentors.get(i);
				if (mentor != null) {
					mentor.setTeam(team);
				}
			}
		}
	}
}
