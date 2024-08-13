package org.example.exo_hexagonal.domain.service;

import org.example.exo_hexagonal.shared.dto.ReservationDTO;
import org.example.exo_hexagonal.shared.port.ReservationPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService extends BaseService<ReservationDTO, Long> {

    private final ReservationPort reservationPort;

    public ReservationService(ReservationPort reservationPort) {
        this.reservationPort = reservationPort;
    }

    @Override
    public List<ReservationDTO> getAll() {
        return reservationPort.getAll();
    }

    @Override
    public ReservationDTO getById(Long id) {
        return reservationPort.getById(id);
    }

    @Override
    public ReservationDTO save(ReservationDTO reservationDTO) {
        return reservationPort.save(reservationDTO);
    }

    @Override
    public ReservationDTO update(Long id, ReservationDTO reservationDTO) {
        return reservationPort.update(id, reservationDTO);
    }

    @Override
    public void delete(Long id) {
        reservationPort.delete(id);
    }
}