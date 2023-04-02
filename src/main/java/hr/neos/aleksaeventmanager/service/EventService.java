package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.dto.EventResponseDto;
import hr.neos.aleksaeventmanager.entity.Event;

public interface EventService {
    EventResponseDto create(EventRequestDto dto);

    Event getById(Long id);

}
