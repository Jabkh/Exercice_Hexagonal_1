package org.example.exo_hexagonal.infrastructure.springdata.repository;

import org.example.exo_hexagonal.domain.model.Event;
import org.example.exo_hexagonal.shared.dto.EventDTO;
import org.example.exo_hexagonal.infrastructure.springdata.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}