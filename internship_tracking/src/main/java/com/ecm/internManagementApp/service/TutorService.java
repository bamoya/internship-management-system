package com.ecm.internManagementApp.service;

import com.ecm.internManagementApp.model.entities.Tutor;
import com.ecm.internManagementApp.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    @Autowired
    TutorRepository tutorRepository;

    public boolean existById(Long id){
        return tutorRepository.existsById(id);
    }

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public Tutor getTutorById(Long id) {
        if (!tutorRepository.existsById(id)){
            throw new RuntimeException(String.format("Tutor by id %id not found",id));
        }
        return tutorRepository.getById(id);
    }

    public Tutor saveTutor(Tutor tutorData) {
        return tutorRepository.save(tutorData);
    }

    public Tutor updateTutor(Long id, Tutor tutorData) {
        if (!tutorRepository.existsById(id)){
            throw new RuntimeException(String.format("Tutor by id %id not found",id));
        }
        tutorData.setId(id);
        return tutorRepository.save(tutorData);
    }

    public void deleteTutor(Long id) {
        if (!tutorRepository.existsById(id)){
            throw new RuntimeException(String.format("Tutor by id %id not found",id));
        }
        tutorRepository.deleteById(id);
    }
}
