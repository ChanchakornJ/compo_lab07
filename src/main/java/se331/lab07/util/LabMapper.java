package se331.lab07.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab07.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);
    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);
    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);

}
