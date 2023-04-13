package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationResponseDto;
import hr.neos.aleksaeventmanager.entity.Registration;

public interface RegistrationService {

    RegistrationResponseDto create(RegistrationRequestDto dto, Long eventId);

    Registration getById(Long id);
    void deleteById(Long registration_id, Long event_id);

}
