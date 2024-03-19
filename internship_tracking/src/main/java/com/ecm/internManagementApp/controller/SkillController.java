package com.ecm.internManagementApp.controller;

import com.ecm.internManagementApp.model.entities.Skill;
import com.ecm.internManagementApp.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/skills")
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping
    public ResponseEntity<?> getAllSkills(@RequestParam(required = false) String code){
        if (code == null){
            return new ResponseEntity<>(skillService.getAllSkills(), HttpStatus.OK);
        }
        if (!skillService.existsByCode(code)){
            return new ResponseEntity<>("Skill with code "+code+"notfound.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(skillService.getSkillByCode(code), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSkillById(@PathVariable Long id){
        if (!skillService.existsById(id)){
            return new ResponseEntity<>(
                    String.format("Skill by id %d not found.",id),
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(skillService.getSkillById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addSkill(@RequestBody Skill skillData){
        if (skillService.existsByCode(skillData.getCode())){
            return new ResponseEntity<>(
                    "Skill with code +"+skillData.getCode()+" already exists",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(skillService.saveSkill(skillData), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id, @RequestBody Skill skillData){
        if (!skillService.existsById(id)){
            return new ResponseEntity<>(
                    "Skill with id "+id+" not found.",
                    HttpStatus.NOT_FOUND
            );
        }
        try {
            return new ResponseEntity<>(skillService.saveSkill(skillData),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long id){
        if (!skillService.existsById(id)){
            return new ResponseEntity<>(
                    "Skill with id "+id+" not found.",
                    HttpStatus.NOT_FOUND
            );
        }
        skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
