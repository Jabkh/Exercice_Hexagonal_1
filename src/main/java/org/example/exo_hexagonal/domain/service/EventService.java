package org.example.exo_hexagonal.domain.service;

import org.example.exo_hexagonal.shared.dto.EventDTO;
import org.example.exo_hexagonal.shared.port.EventPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService extends BaseService<EventDTO, Long> {

    private final EventPort eventPort;

    public EventService(EventPort eventPort) {
        this.eventPort = eventPort;
    }

    @Override
    public List<EventDTO> getAll() {
        return eventPort.getAll();
    }

    @Override
    public EventDTO getById(Long id) {
        return eventPort.getById(id);
    }

    @Override
    public EventDTO save(EventDTO eventDTO) {
        return eventPort.save(eventDTO);
    }

    @Override
    public EventDTO update(Long id, EventDTO eventDTO) {
        return eventPort.update(id, eventDTO);
    }

    @Override
    public void delete(Long id) {
        eventPort.delete(id);
    }
}