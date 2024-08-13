package  org.example.exo_hexagonal.adapter.rest.config;


import  org.example.exo_hexagonal.domain.service.EventService;
import  org.example.exo_hexagonal.domain.service.ReservationService;
import  org.example.exo_hexagonal.infrastructure.springdata.portimpl.EventServiceImpl;
import  org.example.exo_hexagonal.infrastructure.springdata.portimpl.ReservationServiceImpl;
import  org.example.exo_hexagonal.infrastructure.springdata.repository.EventRepository;
import  org.example.exo_hexagonal.infrastructure.springdata.repository.ReservationRepository;

import  org.example.exo_hexagonal.shared.port.EventPort;
import  org.example.exo_hexagonal.shared.port.ReservationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final EventRepository eventRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public AppConfig(EventRepository eventRepository, ReservationRepository reservationRepository) {
        this.eventRepository = eventRepository;
        this.reservationRepository = reservationRepository;
    }

    @Bean
    public EventService eventService() {
        return new EventService(eventPort());
    }

    @Bean
    public EventPort eventPort() {
        return new EventServiceImpl(eventRepository);
    }

    @Bean
    public ReservationService reservationService() {
        return new ReservationService(reservationPort());
    }

    @Bean
    public ReservationPort reservationPort() {
        return new ReservationServiceImpl(reservationRepository);
    }
}