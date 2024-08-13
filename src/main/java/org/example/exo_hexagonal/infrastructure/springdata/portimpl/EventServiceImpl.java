package org.example.exo_hexagonal.infrastructure.springdata.portimpl;

import org.example.exo_hexagonal.infrastructure.springdata.entity.EventEntity;
import org.example.exo_hexagonal.shared.dto.EventDTO;
import org.example.exo_hexagonal.domain.model.Event;
import org.example.exo_hexagonal.shared.port.EventPort;
import org.example.exo_hexagonal.infrastructure.springdata.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventPort {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventDTO> getAll() {
        return ((List<EventEntity>)eventRepository.findAll()).stream()
                .map((eventEntity -> new EventDTO(eventEntity.getId(), eventEntity.getDescription(), eventEntity.getName())))
                .toList();
    }

    @Override
    public EventDTO getById(Long aLong) {
        return null;
    }

    @Override
    public EventDTO save(EventDTO event) {
        EventEntity eventEntity = EventEntity.builder()
                .name(event.getName())
                .description(event.getDescription())
                .build();
        eventEntity = eventRepository.save(eventEntity);
        return new EventDTO(eventEntity.getId(), eventEntity.getName(), eventEntity.getDescription());
    }

    @Override
    public EventDTO update(Long id, EventDTO eventDTO) {
        if (eventRepository.existsById(id)) {
            EventEntity eventEntity = convertToEntity(eventDTO);
            eventEntity.setId(id);
            return convertToDTO(eventRepository.save(eventEntity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    private EventDTO convertToDTO(EventEntity eventEntity) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(eventEntity.getId());
        eventDTO.setName(eventEntity.getName());
        eventDTO.setDescription(eventEntity.getDescription());
        return eventDTO;
    }

    private EventEntity convertToEntity(EventDTO eventDTO) {
        EventEntity eventEntity = EventEntity.builder()
                .name(eventDTO.getName())
                .description(eventDTO.getDescription())
                .build();
        return eventEntity;
    }
}