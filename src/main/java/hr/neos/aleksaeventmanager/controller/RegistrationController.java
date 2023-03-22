package hr.neos.aleksaeventmanager.controller;

import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationResponseDto;
import hr.neos.aleksaeventmanager.service.RegistrationService;
import hr.neos.aleksaeventmanager.validator.EventValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event/{event_id}/registrations")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    private ResponseEntity<?> create(@PathVariable Long event_id, @RequestBody RegistrationRequestDto registrationRequestDto) {
        RegistrationResponseDto savedRegistration = registrationService.create(registrationRequestDto);
        return new ResponseEntity<>(savedRegistration, HttpStatus.CREATED);
    }
}
