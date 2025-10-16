package se331.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Participant;
import se331.lab.repository.ParticipantRepository;

@Repository
@RequiredArgsConstructor
public class ParticipantDaoDbImpl implements ParticipantDao {
    final ParticipantRepository participantRepositoty;

    @Override
    public Page<Participant> getParticipant(Pageable pageRequest) {
        return participantRepositoty.findAll(pageRequest);
    }
}
