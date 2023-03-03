package hr.neos.aleksaeventmanager.service;

import hr.neos.aleksaeventmanager.dto.EventRequestDto;
import hr.neos.aleksaeventmanager.dto.EventResponseDto;
import hr.neos.aleksaeventmanager.entity.Event;
import hr.neos.aleksaeventmanager.mapper.EventMapper;
import hr.neos.aleksaeventmanager.repository.EventRepository;
import hr.neos.aleksaeventmanager.validator.EventValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    private final EventValidator eventValidator;
    private final EventMapper eventMapper;

    @Override
    public EventResponseDto create (EventRequestDto dto){
        eventValidator.validate(dto);
        Event event = eventMapper.toEntity(dto);
        event = eventRepository.save(event);
        return eventMapper.toDto(event);
    }

}
