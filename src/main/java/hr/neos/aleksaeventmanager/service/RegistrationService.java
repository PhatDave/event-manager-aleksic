package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationResponseDto;

public interface RegistrationService {

    RegistrationResponseDto create (RegistrationRequestDto dto);
}
