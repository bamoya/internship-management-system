package com.ecm.internManagementApp.service;

import com.ecm.internManagementApp.model.entities.Internship;
import com.ecm.internManagementApp.repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternService {
    @Autowired
    InternRepository internRepository;

    public boolean existsById(Long id) {
        return internRepository.existsById(id);
    }

    public List<Internship> getAllInternships() {
        return internRepository.findAll();
    }

    public Optional<Internship> getInternshipById(Long id) {
        if (!internRepository.existsById(id)){
            throw new RuntimeException("Internship By id "+id+" not found.");
        }
        return internRepository.findById(id);
    }

    public Internship saveInternship(Internship internshipData) {
        return internRepository.save(internshipData);
    }

    public Internship updateInternship(Long id, Internship internshipData) {
        if (!internRepository.existsById(id)){
            throw new RuntimeException("Internship By id "+id+" not found.");
        }
        internshipData.setId(id);
        return internRepository.save(internshipData);
    }

    public void deleteInternship(Long id) {
        if (!internRepository.existsById(id)){
            throw new RuntimeException("Internship By id "+id+" not found.");
        }
        internRepository.deleteById(id);
    }
}
