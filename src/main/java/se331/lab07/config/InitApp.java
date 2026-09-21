package se331.lab07.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab07.entity.Event;
import se331.lab07.entity.Organizer;
import se331.lab07.entity.Participant;
import se331.lab07.entity.ParticipantOwnEventsDTO;
import se331.lab07.repository.EventRepository;
import se331.lab07.repository.OrganizerRepository;
import se331.lab07.repository.ParticipantRepository;

import java.util.List;


@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
                Organizer org1, org2, org3;
                org1 = organizerRepository.save(Organizer.builder()
                                .name("CAMT").build());
                org2 = organizerRepository.save(Organizer.builder()
                        .name("CMU").build());
                org3 = organizerRepository.save(Organizer.builder()
                        .name("ChiangMai").build());
                Participant par1, par2, par3, par4, par5;
                par1 = participantRepository.save(Participant.builder()
                        .name("Xie Lian").build());
                par2 = participantRepository.save(Participant.builder()
                        .name("Hua Cheng").build());
                par3 = participantRepository.save(Participant.builder()
                        .name("Hinata").build());
                par4 = participantRepository.save(Participant.builder()
                        .name("Akaashi").build());
                par5 = participantRepository.save(Participant.builder()
                        .name("Momonga").build());
                Event tempEvent;
                tempEvent = eventRepository.save(Event.builder()
                        .category("Academic")
                        .title("Midterm Exam")
                        .description("A time for taking the exam")
                        .location("CAMT Building")
                        .date("3rd Sept")
                        .time("3.00-4.00 pm.")
                        .petsAllowed(false)
                        .build());
                tempEvent.setOrganizer(org1);
                org1.getOwnEvents().add(tempEvent);
                tempEvent.setParticipants(List.of(par1, par2, par3));

            ParticipantOwnEventsDTO eventDTO = ParticipantOwnEventsDTO.builder()
                    .id(tempEvent.getId())
                    .category(tempEvent.getCategory())
                    .title(tempEvent.getTitle())
                    .description(tempEvent.getDescription())
                    .location(tempEvent.getLocation())
                    .date(tempEvent.getDate())
                    .time(tempEvent.getTime())
                    .PetsAllowed(tempEvent.getPetsAllowed())
                    .build();

            par1.getOwnEvents().add(eventDTO);
            par2.getOwnEvents().add(eventDTO);
            par3.getOwnEvents().add(eventDTO);
                tempEvent = eventRepository.save(Event.builder()
                        .category("Academic")
                        .title("Commencement Day")
                        .description("A time for celebration")
                        .location("CMU Convention hall")
                        .date("21th Jan")
                        .time("8.00am-4.00 pm.")
                        .petsAllowed(false)
                        .build());
                tempEvent.setOrganizer(org1);
                org1.getOwnEvents().add(tempEvent);
                tempEvent.setParticipants(List.of(par1, par2, par4));
                eventDTO = ParticipantOwnEventsDTO.builder()
                        .id(tempEvent.getId())
                        .category(tempEvent.getCategory())
                        .title(tempEvent.getTitle())
                        .description(tempEvent.getDescription())
                        .location(tempEvent.getLocation())
                        .date(tempEvent.getDate())
                        .time(tempEvent.getTime())
                        .PetsAllowed(tempEvent.getPetsAllowed())
                        .build();

                par1.getOwnEvents().add(eventDTO);
                par2.getOwnEvents().add(eventDTO);
                par4.getOwnEvents().add(eventDTO);

                tempEvent = eventRepository.save(Event.builder()
                        .category("Cultural")
                        .title("Loy Krathong")
                        .description("A time for Krathong")
                        .location("Ping River")
                        .date("21th Nov")
                        .time("8.00-10.00 pm.")
                        .petsAllowed(false)
                        .build());
                tempEvent.setOrganizer(org2);
                org2.getOwnEvents().add(tempEvent);
                tempEvent.setParticipants(List.of(par3, par4, par5));
                eventDTO = ParticipantOwnEventsDTO.builder()
                        .id(tempEvent.getId())
                        .category(tempEvent.getCategory())
                        .title(tempEvent.getTitle())
                        .description(tempEvent.getDescription())
                        .location(tempEvent.getLocation())
                        .date(tempEvent.getDate())
                        .time(tempEvent.getTime())
                        .PetsAllowed(tempEvent.getPetsAllowed())
                        .build();

                par3.getOwnEvents().add(eventDTO);
                par4.getOwnEvents().add(eventDTO);
                par5.getOwnEvents().add(eventDTO);


                tempEvent = eventRepository.save(Event.builder()
                        .category("Cultural")
                        .title("Songkran")
                        .description("Let's Play Water")
                        .location("Chiang Mai Moat")
                        .date("13th April")
                        .time("10.00am - 6.00 pm.")
                        .petsAllowed(true)
                        .build());

                tempEvent.setOrganizer(org3);
                org3.getOwnEvents().add(tempEvent);
                tempEvent.setParticipants(List.of(par1, par3, par4));
                eventDTO = ParticipantOwnEventsDTO.builder()
                        .id(tempEvent.getId())
                        .category(tempEvent.getCategory())
                        .title(tempEvent.getTitle())
                        .description(tempEvent.getDescription())
                        .location(tempEvent.getLocation())
                        .date(tempEvent.getDate())
                        .time(tempEvent.getTime())
                        .PetsAllowed(tempEvent.getPetsAllowed())
                        .build();

                par1.getOwnEvents().add(eventDTO);
                par3.getOwnEvents().add(eventDTO);
                par4.getOwnEvents().add(eventDTO);
    }

}
