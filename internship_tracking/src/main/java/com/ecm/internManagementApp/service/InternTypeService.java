package com.ecm.internManagementApp.service;

import com.ecm.internManagementApp.model.entities.InternshipType;
import com.ecm.internManagementApp.repository.InternTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternTypeService {
    @Autowired
    InternTypeRepository internTypeRepository;

    public List<InternshipType> getAllInternTypes() {
        return internTypeRepository.findAll();
    }

    public InternshipType saveInternType(InternshipType internshipTypeData) {
        return internTypeRepository.save(internshipTypeData);
    }

    public boolean existsById(Long id) {
        return internTypeRepository.existsById(id);
    }

    public Optional<InternshipType> getInternTypeById(Long id) {
        if (!internTypeRepository.existsById(id)){
            throw new RuntimeException("Intern type with id "+ id+" not found.");
        }
        return internTypeRepository.findById(id);
    }

    public InternshipType updateInternType(Long id, InternshipType internshipTypeData) {
        if (!internTypeRepository.existsById(id)){
            throw new RuntimeException("Intern type with id "+ id+" not found.");
        }
        internshipTypeData.setId(id);
        return internTypeRepository.save(internshipTypeData);
    }

    public void deleteInternType(Long id) {
        if (!internTypeRepository.existsById(id)){
            throw new RuntimeException("Intern type with id "+ id+" not found.");
        }
        internTypeRepository.deleteById(id);
    }
}
