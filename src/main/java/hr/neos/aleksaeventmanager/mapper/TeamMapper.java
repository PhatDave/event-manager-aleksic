package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.TeamRequestDto;
import hr.neos.aleksaeventmanager.entity.Mentor;
import hr.neos.aleksaeventmanager.entity.Team;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(
        uses = {
                MentorMapper.class
        },
        builder = @Builder(disableBuilder = true)
)
public interface TeamMapper {

    Team toEntity(TeamRequestDto dto);

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

	/*@AfterMapping
	default void mapTeamIdInUser(@MappingTarget Team team) {
		List<User> users = team.getUsers();
		if (users != null) {
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
				if (user != null) {
					user.setTeam(team);
				}
			}
		}
	}*/


}
