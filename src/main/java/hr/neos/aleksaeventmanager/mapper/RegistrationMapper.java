package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.PersonalRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationResponseDto;
import hr.neos.aleksaeventmanager.entity.Education;
import hr.neos.aleksaeventmanager.entity.Experience;
import hr.neos.aleksaeventmanager.entity.Registration;
import hr.neos.aleksaeventmanager.entity.User;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
		uses = {
				PersonalMapper.class,
				ExperienceMapper.class,
				EducationMapper.class
		},
		builder = @Builder(disableBuilder = true)
)
public abstract class RegistrationMapper {

	@Autowired
	private ExperienceMapper experienceMapper;

	@Autowired
	private EducationMapper educationMapper;

	@Mapping(source = "personal.name.first", target = "user.personalInfo.firstName")
	@Mapping(source = "personal.name.last", target = "user.personalInfo.lastName")
	@Mapping(source = "personal", target = "user.personalInfo")
	@Mapping(source = "personal.summary", target = "user.otherUserInfo.summary")
	@Mapping(source = "motivation", target = "user.otherUserInfo.motivation")
	@Mapping(source = "preferredOS", target = "user.otherUserInfo.preferredOS")
	public abstract Registration toEntity(RegistrationRequestDto dto);

	@Mapping(source = "user.personalInfo.firstName", target = "personal.name.first")
	@Mapping(source = "user.personalInfo.lastName", target = "personal.name.last")
	@Mapping(source = "user.personalInfo.email", target = "personal.email")
	@Mapping(source = "user.personalInfo.phone", target = "personal.phone")
	@Mapping(source = "user.experience", target = "experience")
	@Mapping(source = "user.otherUserInfo.summary", target = "personal.summary")
	@Mapping(source = "user.otherUserInfo.motivation", target = "motivation")
	@Mapping(source = "user.otherUserInfo.preferredOS", target = "preferredOS")
	public abstract RegistrationResponseDto toDto(Registration registration);

	@AfterMapping
	public void mapRegistrationIdInUser(@MappingTarget Registration registration) {
		registration.getUser().setRegistration(registration);
	}

	//ToDo: clone this method to team

	@AfterMapping
	public void mapExperienceInUser(RegistrationRequestDto dto, @MappingTarget Registration registration) {
		if (dto.getExperience() != null) {
			registration.getUser().setExperience(experienceMapper.toEntity(dto.getExperience()));
			registration.getUser().getExperience().setUser(registration.getUser());
		}
	}

	@AfterMapping
	public void mapUserIdInEducation(RegistrationRequestDto dto, @MappingTarget Registration registration) {
		if (dto.getPersonal().getEducation() != null) {
			registration.getUser().setEducation(educationMapper.toEntity(dto.getPersonal().getEducation()));
			registration.getUser().getEducation().setUser(registration.getUser());
		}
	}

}
