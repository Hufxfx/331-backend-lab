package se331.lab.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Transactional
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        Organizer org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        Organizer org3 = organizerRepository.save(Organizer.builder().name("ChiangMai").build());

        Participant p1 = participantRepository.save(Participant.builder().name("Lisa").telNo("081-111-1111").build());
        Participant p2 = participantRepository.save(Participant.builder().name("Rose").telNo("082-222-2222").build());
        Participant p3 = participantRepository.save(Participant.builder().name("Jisoo").telNo("083-333-3333").build());
        Participant p4 = participantRepository.save(Participant.builder().name("Canny").telNo("084-444-4444").build());
        Participant p5 = participantRepository.save(Participant.builder().name("Jenny").telNo("085-555-5555").build());


        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        Event e1 = tempEvent;

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Exam")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        Event e2 = tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21 Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        Event e3 = tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("SongKran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        Event e4 = tempEvent;

        List<Participant> pool = Arrays.asList(p1, p2, p3, p4, p5);
        List<Participant> shuffled = new ArrayList<>(pool);
        Collections.shuffle(shuffled);

        e1.setParticipants(new ArrayList<>(Arrays.asList(shuffled.get(0), shuffled.get(1), shuffled.get(2))));
        e2.setParticipants(new ArrayList<>(Arrays.asList(shuffled.get(1), shuffled.get(2), shuffled.get(3))));
        e3.setParticipants(new ArrayList<>(Arrays.asList(shuffled.get(2), shuffled.get(3), shuffled.get(4))));
        e4.setParticipants(new ArrayList<>(Arrays.asList(shuffled.get(3), shuffled.get(4), shuffled.get(0))));

        eventRepository.save(e1);
        eventRepository.save(e2);
        eventRepository.save(e3);
        eventRepository.save(e4);
    }
}
