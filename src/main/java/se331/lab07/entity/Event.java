package se331.lab07.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import se331.lab07.entity.Organizer;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petsAllowed;
    @ManyToOne
    Organizer organizer;
    @ManyToMany
    List<Participant> participants;
}
