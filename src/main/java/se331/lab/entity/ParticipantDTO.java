package se331.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDTO {
    Long id;
    String name;
    String telNo;
    List<EventOwnParticipantDTO> ownParticipants = new ArrayList<>();
}
