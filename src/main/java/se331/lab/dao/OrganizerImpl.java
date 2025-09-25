//package se331.lab.dao;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Repository;
//import se331.lab.entity.Organizer;
//import se331.lab.repository.OrganizerRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//@Profile("manual")
//public class OrganizerImpl implements OrganizerDao{
//    final OrganizerRepository organizerRepository;
//    List<Organizer> organizerList;
//
//    public OrganizerImpl(OrganizerRepository organizerRepository) {
//        this.organizerRepository = organizerRepository;
//    }
//
//    @PostConstruct
//    public void init() {
//        organizerList = new ArrayList<>();
//        organizerList.add(Organizer.builder()
//                .id(123L)
//                .organization("Fern Pollin")
//                .address("Flora City")
//                .build());
//        organizerList.add(Organizer.builder()
//                .id(124L)
//                .organization("Carey Wales")
//                .address("Playa Del Carmen")
//                .build());
//        organizerList.add(Organizer.builder()
//                .id(125L)
//                .organization("Dawg Dahd")
//                .address("Woof Town")
//                .build());
//    }
//    @Override
//    public Integer getOrganizerSize() {
//        return organizerList.size();
//    }
//
//    @Override
//    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
//        pageSize = pageSize == null ? organizerList.size() : pageSize;
//        page = page == null ? 1 : Math.max(1, page);
//        int firstIndex = (page - 1) * pageSize;
//        int lastIndexExclusive = Math.min(firstIndex + pageSize, organizerList.size());
//        if (firstIndex >= organizerList.size()) {
//            return new PageImpl<>(List.of(), PageRequest.of(page - 1, pageSize), organizerList.size());
//        }
//        return new PageImpl<>(organizerList.subList(firstIndex, lastIndexExclusive), PageRequest.of(page - 1, pageSize), organizerList.size());
//    }
//    @Override
//    public Organizer getOrganizer(Long id) {
//        Organizer output = null;
//        for (Organizer organizer : organizerList) {
//            if (organizer.getId().equals(id)) {
//                output = organizer;
//                break;
//            }
//        }
//        return output;
//    }
//
//    @Override
//    public Organizer save(Organizer organizer) {
//        organizer.setId(organizerList.get(organizerList.size() - 1).getId() + 1);
//        organizerList.add(organizer);
//        return organizer;
//    }
//}
