package hr.neos.aleksaeventmanager.controller;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.dto.EventResponseDto;
import hr.neos.aleksaeventmanager.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody EventRequestDto eventRequestDto){
        EventResponseDto savedEvent = eventService.create(eventRequestDto);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }
}
