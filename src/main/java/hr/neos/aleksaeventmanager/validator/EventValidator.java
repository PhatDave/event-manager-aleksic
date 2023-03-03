package hr.neos.aleksaeventmanager.validator;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventValidator {
    private final EventRepository eventRepository;

    public void validate(EventRequestDto dto){
        validateEventName(dto);
    }

    public void validateEventName(EventRequestDto dto){
        if(this.eventRepository.existsByName(dto.getName())){
            throw new IllegalStateException("Event with name " + dto.getName() + " already exists.");
        }
    }
}
