package se331.lab07.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab07.entity.Participant;

import java.util.Optional;


public interface ParticipantDao {
    Page<Participant> getParticipant(Pageable pageRequest);
    Optional<Participant> findById(Long id);

}
