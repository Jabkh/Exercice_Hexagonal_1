package org.example.exo_hexagonal.infrastructure.springdata.portimpl;

import org.example.exo_hexagonal.infrastructure.springdata.entity.ReservationEntity;
import org.example.exo_hexagonal.shared.dto.ReservationDTO;
import org.example.exo_hexagonal.shared.port.ReservationPort;
import org.example.exo_hexagonal.infrastructure.springdata.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl extends BaseServiceImpl<ReservationEntity, ReservationDTO, Long> implements ReservationPort {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        super(reservationRepository);
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<ReservationDTO> getAll() {
        return super.getAll();
    }

    @Override
    public ReservationDTO getById(Long aLong) {
        return super.getById(aLong);
    }

    @Override
    public ReservationDTO save(ReservationDTO reservationDTO) {
        return super.save(reservationDTO);
    }

    @Override
    public ReservationDTO update(Long aLong, ReservationDTO reservationDTO) {
        return super.update(aLong, reservationDTO);
    }

    @Override
    public void delete(Long aLong) {
        super.delete(aLong);
    }

    @Override
    protected ReservationDTO convertToDTO(ReservationEntity reservationEntity) {
        return new ReservationDTO(reservationEntity.getId(), reservationEntity.getEventId(), reservationEntity.getUserName(), reservationEntity.getNumberOfTickets());
    }

    @Override
    protected ReservationEntity convertToEntity(ReservationDTO reservationDTO) {
        return ReservationEntity.builder()
                .eventId(reservationDTO.getEventId())
                .userName(reservationDTO.getUserName())
                .numberOfTickets(reservationDTO.getNumberOfTickets())
                .build();
    }

    @Override
    protected void setId(ReservationEntity reservationEntity, Long id) {
        reservationEntity.setId(id);
    }
}