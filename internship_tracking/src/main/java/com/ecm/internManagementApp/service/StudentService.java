package com.ecm.internManagementApp.service;

import com.ecm.internManagementApp.exception.StudentNotFoundException;
import com.ecm.internManagementApp.model.entities.Student;
import com.ecm.internManagementApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public boolean isExists(Long id){
        return studentRepository.existsById(id);
    }

    public Optional<Student> getStudentById(Long id) {
        // Implement logic to get a student by ID
//        Optional<Student> optionalStudent = studentRepository.findById(id);
        return studentRepository.findById(id);
//                .orElseThrow(()-> new StudentNotFoundException("student by id " +id+ " was not found."));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveListOfStudents(List<Student> listOfStudents){
        return studentRepository.saveAll(listOfStudents);
    }

    public Student updateStudent(Long id, Student student) {
        // Implement logic to update an existing student
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        throw new StudentNotFoundException("student with id "+id+" not found");
    }

    public Student partialUpdate(Long id, Student student){
        student.setId(id);
        return studentRepository.findById(id).map((existingStudent) -> {
            Optional.ofNullable(student.getFirstName()).ifPresent(existingStudent::setFirstName);
            Optional.ofNullable(student.getLastName()).ifPresent(existingStudent::setLastName);
            Optional.ofNullable(student.getCity()).ifPresent(existingStudent::setCity);
            Optional.ofNullable(student.getAddress()).ifPresent(existingStudent::setAddress);
            Optional.ofNullable(student.getPhone()).ifPresent(existingStudent::setPhone);
            Optional.ofNullable(student.getDateOfBirth()).ifPresent(existingStudent::setDateOfBirth);
            Optional.ofNullable(student.getPostalCode()).ifPresent(existingStudent::setPostalCode);
            Optional.ofNullable(student.getPromo()).ifPresent(existingStudent::setPromo);
            return studentRepository.save(existingStudent);
        }).orElseThrow(() -> new RuntimeException("Student not found."));
    }

    public void deleteStudent(Long id) {
        // Implement logic to delete a student by ID
        studentRepository.deleteById(id);
    }
}