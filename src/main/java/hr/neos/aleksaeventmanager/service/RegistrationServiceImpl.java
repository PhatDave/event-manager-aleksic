package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationResponseDto;
import hr.neos.aleksaeventmanager.entity.Event;
import hr.neos.aleksaeventmanager.entity.Registration;
import hr.neos.aleksaeventmanager.mapper.RegistrationMapper;
import hr.neos.aleksaeventmanager.repository.RegistrationRepository;
import hr.neos.aleksaeventmanager.validator.EventValidator;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationMapper registrationMapper;
    private final RegistrationRepository registrationRepository;
    private final EventValidator eventValidator;
    private final EventService eventService;

    @SneakyThrows
    @Override
    public RegistrationResponseDto create(RegistrationRequestDto registrationDto, Long eventId) {
        Event event = eventService.getById(eventId);
        eventValidator.validateEventAcceptReg(event);
        Registration registration = registrationMapper.toEntity(registrationDto);
        registration.setUuid(UUID.randomUUID().toString());
        registration.setEvent(event);
        registration = registrationRepository.save(registration);
        return registrationMapper.toDto(registration);
    }

    @Override
    public Registration getById(Long id) {
        return this.registrationRepository.findById(id).orElseThrow(() -> new
                NoSuchElementException("Registration with id " + id + " does not exists."));
    }

    @Override
    public void deleteById(Long registration_id, Long event_id) {
        eventService.getById(event_id);
        Registration registration = getById(registration_id);
        if (registration.getEvent().getId().equals(event_id)){
            registrationRepository.deleteById(registration_id);
        } else {
            throw new IllegalStateException("Registration " + registration_id + " is not part of event " + event_id);
        }

    }

}

