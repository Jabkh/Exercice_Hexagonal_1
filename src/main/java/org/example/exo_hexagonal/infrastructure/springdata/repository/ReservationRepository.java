package org.example.exo_hexagonal.infrastructure.springdata.repository;

import org.example.exo_hexagonal.domain.model.Reservation;
import org.example.exo_hexagonal.shared.dto.ReservationDTO;
import org.example.exo_hexagonal.infrastructure.springdata.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}