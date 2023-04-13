package hr.neos.aleksaeventmanager.controller;

import hr.neos.aleksaeventmanager.dto.RegistrationRequestDto;
import hr.neos.aleksaeventmanager.dto.RegistrationResponseDto;
import hr.neos.aleksaeventmanager.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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
        RegistrationResponseDto savedRegistration = registrationService.create(registrationRequestDto, event_id);
        return new ResponseEntity<>(savedRegistration, HttpStatus.CREATED);
    }

    @DeleteMapping("/{registration_id}")
    private ResponseEntity<Void> deleteById(@PathVariable Long registration_id, @PathVariable Long event_id) {
        try {
            registrationService.deleteById(registration_id, event_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
  