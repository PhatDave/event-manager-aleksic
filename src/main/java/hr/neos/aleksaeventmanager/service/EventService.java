package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.dto.EventResponseDto;
import hr.neos.aleksaeventmanager.dto.TeamRequestDto;
import hr.neos.aleksaeventmanager.entity.Event;
import hr.neos.aleksaeventmanager.entity.Team;

import java.util.List;

public interface EventService {
    EventResponseDto create (EventRequestDto dto);

}
