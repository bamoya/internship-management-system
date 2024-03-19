package com.ecm.internManagementApp.controller;

import com.ecm.internManagementApp.model.entities.InternshipType;
import com.ecm.internManagementApp.service.InternTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/intern-types")
public class InternshipTypeController {
    @Autowired
    InternTypeService internTypeService;

    @GetMapping
    public ResponseEntity<List<InternshipType>> getAllInternTypes(){
        return new ResponseEntity<>(
                internTypeService.getAllInternTypes(),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InternshipType> saveInternType(@RequestBody InternshipType internshipTypeData){
        return new ResponseEntity<>(
                internTypeService.saveInternType(internshipTypeData),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInternTypeById(@PathVariable Long id){
        if (!internTypeService.existsById(id)){
            return new ResponseEntity<>(
                    "Intern type with id "+ id+" not found.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                internTypeService.getInternTypeById(id),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInternType(
            @PathVariable Long id,
            @RequestBody InternshipType internshipTypeData
            ){
        if (!internTypeService.existsById(id)){
            return new ResponseEntity<>(
                    "Intern type with id "+ id+" not found.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                internTypeService.updateInternType(id, internshipTypeData),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInternType(@PathVariable Long id){
        if (!internTypeService.existsById(id)){
            return new ResponseEntity<>(
                    "Intern type with id "+ id+" not found.",
                    HttpStatus.NOT_FOUND
            );
        }
        internTypeService.deleteInternType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
