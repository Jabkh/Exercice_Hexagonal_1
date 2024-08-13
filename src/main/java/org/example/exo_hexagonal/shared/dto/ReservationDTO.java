package org.example.exo_hexagonal.shared.dto;

public class ReservationDTO {
    private Long id;
    private Long eventId;
    private String userName;
    private int numberOfTickets;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id, Long eventId, String userName, int numberOfTickets) {
        this.id = id;
        this.eventId = eventId;
        this.userName = userName;
        this.numberOfTickets = numberOfTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
