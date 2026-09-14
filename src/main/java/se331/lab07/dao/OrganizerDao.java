package se331.lab07.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab07.entity.Organizer;

public interface OrganizerDao {
    Page<Organizer> getOrganizer(Pageable pageRequest);
}
