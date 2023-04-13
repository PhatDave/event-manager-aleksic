package hr.neos.aleksaeventmanager.validator;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.dto.EventResponseDto;
import hr.neos.aleksaeventmanager.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class EventValidator {
    private final EventRepository eventRepository;

    public void validateEventName(EventRequestDto dto) {
        if (this.eventRepository.existsByName(dto.getName())) {
            throw new IllegalStateException("Event with name " + dto.getName() + " already exists.");
        }
    }

    public void validateEventAcceptReg(EventResponseDto dto) throws IllegalAccessException {
        Date currentDate = new Date();

        if (dto.getRegistrationsNotBefore() != null && currentDate.before(dto.getRegistrationsNotBefore())) {
            throw new IllegalAccessException("Registrations are not yet open for this event and cannot be accepted.");
        }

        if (dto.getRegistrationsNotAfter() != null && currentDate.after(dto.getRegistrationsNotAfter())) {
            throw new IllegalAccessException("Registration have closed for this event.");
        }
    }

}
