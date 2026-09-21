package se331.lab07.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    String name;
    String telNo;

    @ManyToMany
    List<Event> eventHistories;

    @Transient
    @Builder.Default
    List<ParticipantOwnEventsDTO> ownEvents = new ArrayList<>();
}