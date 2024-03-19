package com.ecm.internManagementApp.controller;

import com.ecm.internManagementApp.model.entities.Tutor;
import com.ecm.internManagementApp.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tutors")
public class TutorController {
    @Autowired
    TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<Tutor>> getAlltutors(){
        return new ResponseEntity<>(
                tutorService.getAllTutors(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTutorById(@PathVariable Long id){
        if (!tutorService.existById(id)){
            return new ResponseEntity<>(
                    String.format("Tutor by id %d not found.",id),
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(tutorService.getTutorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addTutor(@RequestBody Tutor tutorData){
        return new ResponseEntity<>(
                tutorService.saveTutor(tutorData),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTutor(
            @PathVariable Long id,
            @RequestBody Tutor tutorData){
        if (!tutorService.existById(id)){
            return new ResponseEntity<>(
                    String.format("Tutor by id %d not found.",id),
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                tutorService.updateTutor(id,tutorData),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTutor(@PathVariable Long id){
        if (!tutorService.existById(id)){
            return new ResponseEntity<>(
                    String.format("Tutor by id %d not found.",id),
                    HttpStatus.NOT_FOUND
            );
        }
        tutorService.deleteTutor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
