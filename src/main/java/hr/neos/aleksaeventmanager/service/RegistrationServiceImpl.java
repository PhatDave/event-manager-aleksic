package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationResponseDto;
import hr.neos.aleksaeventmanager.entity.Registration;
import hr.neos.aleksaeventmanager.mapper.RegistrationMapper;
import hr.neos.aleksaeventmanager.repository.RegistrationRepository;
import hr.neos.aleksaeventmanager.validator.EventValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationMapper registrationMapper;
    private final RegistrationRepository registrationRepository;
    private final EventValidator eventValidator;

    @Override
    public RegistrationResponseDto create(RegistrationRequestDto registrationDto) {
        Registration registration = registrationMapper.toEntity(registrationDto);
        registration = registrationRepository.save(registration);
        return registrationMapper.toDto(registration);
    }

}

