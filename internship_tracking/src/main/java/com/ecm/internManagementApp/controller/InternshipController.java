package com.ecm.internManagementApp.controller;

import com.ecm.internManagementApp.model.entities.Internship;
import com.ecm.internManagementApp.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/internships")
public class InternshipController {
    @Autowired
    InternService internService;

    @GetMapping
    public ResponseEntity<List<Internship>> getAllInternships(){
        return new ResponseEntity<>(
                internService.getAllInternships(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Internship> addInternship(@RequestBody Internship internshipData){
        return new ResponseEntity<>(
                internService.saveInternship(internshipData),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInternshipById(@PathVariable Long id){
        if (! internService.existsById(id)){
            return new ResponseEntity<>(
                    "Internship By id "+id+" not found.",
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                internService.getInternshipById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInternship(
            @PathVariable Long id,
            @RequestBody Internship internshipData){
        if (!internService.existsById(id)){
            return new ResponseEntity<>(
                    "Internship By id "+id+" not found.",
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                internService.updateInternship(id, internshipData),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInternship(@PathVariable Long id ){
        if (!internService.existsById(id)){
            return new ResponseEntity<>(
                    "Internship By id "+id+" not found.",
                    HttpStatus.NOT_FOUND);
        }
        internService.deleteInternship(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
