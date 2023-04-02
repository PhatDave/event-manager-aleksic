package hr.neos.aleksaeventmanager.validator;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.dto.EventResponseDto;
import hr.neos.aleksaeventmanager.entity.Event;
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

    public void validateEventAcceptReg (Event event) throws IllegalAccessException {
        Date currentDate = new Date();

        if (event.getRegistrationsNotBefore() != null && currentDate.before(event.getRegistrationsNotBefore())) {
            throw new IllegalAccessException("Registrations are not yet open for this event and cannot be accepted.");
        }

        if (event.getRegistrationsNotAfter() != null && currentDate.after(event.getRegistrationsNotAfter())) {
            throw new IllegalAccessException("Registration have closed for this event.");
        }
    }

}
