package com.ecm.internManagementApp.controller;

import com.ecm.internManagementApp.model.entities.Enterprise;
import com.ecm.internManagementApp.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enterprises")
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping
    public ResponseEntity<List<Enterprise>> getAllEnterprises(){
        return new ResponseEntity<>(
                enterpriseService.getAllEnterprises(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEnterpriseById(@PathVariable Long id){
        if (!enterpriseService.existsById(id)){
            return new ResponseEntity<>(
                    String.format("Enterprise by id %d not found",id),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                enterpriseService.getEnterpriseById(id),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addEnterprise(@RequestBody Enterprise enterpriseData){
        return new ResponseEntity<>(
                enterpriseService.saveEnterprise(enterpriseData),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEnterprise(
            @PathVariable Long id,
            @RequestBody Enterprise enterpriseData){
        if(!enterpriseService.existsById(id)){
            return new ResponseEntity<>(
                    String.format("Enterprise by id %d not found.", id),
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                enterpriseService.update(id, enterpriseData),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnterprise(@PathVariable Long id){
        if(!enterpriseService.existsById(id)) {
            return new ResponseEntity<>(
                    String.format("Enterprise by id %d not found.", id),
                    HttpStatus.NOT_FOUND
            );
        }
        enterpriseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
