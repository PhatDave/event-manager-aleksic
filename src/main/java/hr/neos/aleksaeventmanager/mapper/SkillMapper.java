package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.SkillRequestDto;
import hr.neos.aleksaeventmanager.dto.SkillResponseDto;
import hr.neos.aleksaeventmanager.entity.Skill;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface SkillMapper {

	Skill toEntity(SkillRequestDto dto);

	SkillResponseDto toDto(Skill skill);
}
