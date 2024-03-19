package com.ecm.internManagementApp.controller;

import com.ecm.internManagementApp.model.entities.Student;
import com.ecm.internManagementApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        if (!studentService.isExists(id)){
            return new ResponseEntity<>(
                    String.format("Student by id %d not found", id),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student studentData) {
        Student newStudent = studentService.saveStudent(studentData);
        return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
    }

//    @PostMapping("/all")
//    public ResponseEntity<List<Student>> saveListOfStudents(@RequestBody List<Student> students) {
//        return new ResponseEntity<>(studentService.saveListOfStudents(students), HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudentt(@PathVariable Long id, @RequestBody Student studentData){
        if (!studentService.isExists(id)){
            return new ResponseEntity<>(
                    String.format("Student by id %d not found.", id),
                    HttpStatus.NOT_FOUND);
        }

        Student updatedStudent = studentService.updateStudent(id, studentData);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<?> partialUpdateStudentt(@PathVariable Long id, @RequestBody Student studentData){
//        Optional<Student> studentOptional = studentService.getStudentById(id);
//        if (studentOptional.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        Student student = studentMapper.mapFromDto(studentDto);
//        Student updatedStudent = studentService.partialUpdate(id, student);
//        return new ResponseEntity<>(studentMapper.mapToDto(updatedStudent), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        if (!studentService.isExists(id)){
            return new ResponseEntity<>(
                    String.format("Student by id %d not found.", id),
                    HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted.",HttpStatus.OK);
    }



}
