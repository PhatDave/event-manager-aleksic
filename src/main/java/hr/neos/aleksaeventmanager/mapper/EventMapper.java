package hr.neos.aleksaeventmanager.mapper;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.dto.EventResponseDto;
import hr.neos.aleksaeventmanager.entity.Event;
import hr.neos.aleksaeventmanager.service.EventService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        builder = @Builder(disableBuilder = true)
)
public interface EventMapper {

    Event toEntity(EventRequestDto dto);

    EventResponseDto toDto(Event event);

}
