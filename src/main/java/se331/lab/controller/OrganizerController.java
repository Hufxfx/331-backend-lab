//package se331.lab.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//import se331.lab.entity.Organizer;
//import se331.lab.service.OrganizerService;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class OrganizerController {
//    final OrganizerService organizerService;
//    @GetMapping("/organizer")
//    public ResponseEntity<?> getOrganizerLists(@RequestParam(value = "_limit",
//                                                  required = false)Integer perPage
//            , @RequestParam(value = "_page",required = false)Integer page) {
//        Page<Organizer> pageOutput = organizerService.getOrganizers(perPage, page);
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
//        return new ResponseEntity<>(pageOutput.getContent(),responseHeaders, HttpStatus.OK);
//    }
//    @GetMapping("/organizer/{id}")
//    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id) {
//        Organizer output = organizerService.getOrganizer(id);
//        if (output != null) {
//            return ResponseEntity.ok(output);
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
//        }
//    }
//
//    @PostMapping("/organizer")
//    public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer) {
//        Organizer output = organizerService.save(organizer);
//        return ResponseEntity.ok(output);
//    }
//}
