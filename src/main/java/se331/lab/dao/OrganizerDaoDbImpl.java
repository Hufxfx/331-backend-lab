//package se331.lab.dao;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Repository;
//import se331.lab.entity.Organizer;
//import se331.lab.repository.OrganizerRepository;
//
//@Repository
//@RequiredArgsConstructor
//@Profile("db")
//public class OrganizerDaoDbImpl implements OrganizerDao {
//    final OrganizerRepository organizerRepository;
//
//    @Override
//    public Integer getOrganizerSize() {
//        return Math.toIntExact(organizerRepository.count());
//    }
//
//    @Override
//    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
//        int pageNumber = (page == null || page < 1) ? 0 : page - 1;   // default = first page
//        int size = (pageSize == null || pageSize < 1) ? 10 : pageSize; // default = 10 items per page
//
//        return organizerRepository.findAll(PageRequest.of(pageNumber, size));
//    }
//
//    @Override
//    public Organizer getOrganizer(Long id) {
//        return organizerRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Organizer save(Organizer organizer) {
//        return organizerRepository.save(organizer);
//    }
//}