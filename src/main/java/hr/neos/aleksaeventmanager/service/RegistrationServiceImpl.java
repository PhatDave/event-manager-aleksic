package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.EventResponseDto;
import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationResponseDto;
import hr.neos.aleksaeventmanager.entity.Event;
import hr.neos.aleksaeventmanager.entity.Registration;
import hr.neos.aleksaeventmanager.mapper.EventMapper;
import hr.neos.aleksaeventmanager.mapper.RegistrationMapper;
import hr.neos.aleksaeventmanager.repository.RegistrationRepository;
import hr.neos.aleksaeventmanager.validator.EventValidator;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationMapper registrationMapper;
    private final RegistrationRepository registrationRepository;
    private final EventValidator eventValidator;
    private final EventService eventService;
    private final EventMapper eventMapper;

    @SneakyThrows
    @Override
    public RegistrationResponseDto create (RegistrationRequestDto registrationDto, Long eventId) {
        Event event = eventService.getById(eventId);
        eventValidator.validateEventAcceptReg(event);
        Registration registration = registrationMapper.toEntity(registrationDto);
        registration.setUuid(UUID.randomUUID().toString());
        registration.setEvent(event);
        registration = registrationRepository.save(registration);
        return registrationMapper.toDto(registration);
    }

}

