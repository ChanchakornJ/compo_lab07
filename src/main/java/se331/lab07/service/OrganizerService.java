package se331.lab07.service;

import org.springframework.data.domain.Page;
import se331.lab07.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer organizer);
}
