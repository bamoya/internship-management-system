package com.ecm.internManagementApp.controller;

import com.ecm.internManagementApp.model.entities.Teacher;
import com.ecm.internManagementApp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Long id) {
        if (!teacherService.isExists(id)){
            return new ResponseEntity<>(
                    String.format("Teacher by id %d not found.", id),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<Teacher>> saveListOfTeachers(@RequestBody List<Teacher> teachers) {
        return new ResponseEntity<>(teacherService.saveListOfTeachers(teachers), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        if (!teacherService.isExists(id)){
            return new ResponseEntity<>(
                    String.format("Teacher by id %d not found.", id),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacherService.updateTeacher(id, teacher), HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Teacher> patchTeacher(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
//        Teacher updatedTeacher = teacherService.patchTeacher(id, updates);
//        if (updatedTeacher != null) {
//            return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
        if (!teacherService.isExists(id)){
            return new ResponseEntity<>(
                    String.format("Teacher by id %d not found.", id),
                    HttpStatus.NOT_FOUND);
        }
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

