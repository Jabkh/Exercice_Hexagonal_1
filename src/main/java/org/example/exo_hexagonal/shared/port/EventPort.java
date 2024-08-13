package org.example.exo_hexagonal.shared.port;

import org.example.exo_hexagonal.domain.model.Event;
import org.example.exo_hexagonal.shared.dto.EventDTO;
import java.util.List;

public interface EventPort extends BasePort<EventDTO,Long>{

}