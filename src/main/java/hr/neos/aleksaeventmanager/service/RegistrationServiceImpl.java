package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.repository.RegistrationRepository;
import hr.neos.aleksaeventmanager.validator.EventValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public interface RegistrationServiceImpl {
    /*private final RegistrationRepository registrationRepository;
    private final EventValidator eventValidator;
    private final RegistrationMapper registrationMapper;
    @Override
    public RegistrationResponseDto create (RegistrationRequestDto dto){
        dto.
    }

    @Override
    public EventResponseDto create(EventRequestDto dto) {
        eventValidator.validateEventName(dto);
        Event event = eventMapper.toEntity(dto);
        event = eventRepository.save(event);
        return eventMapper.toDto(event);
    }*/
}
