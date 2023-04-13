package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.dto.EventResponseDto;

public interface EventService {
    EventResponseDto create(EventRequestDto dto);

}
