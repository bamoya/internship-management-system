package com.ecm.internManagementApp.service;

import com.ecm.internManagementApp.model.entities.Enterprise;
import com.ecm.internManagementApp.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {
    @Autowired
    EnterpriseRepository enterpriseRepository;

    public boolean existsById(Long id){
        return enterpriseRepository.existsById(id);
    }

    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }

    public Optional<Enterprise> getEnterpriseById(Long id) {
        return enterpriseRepository.findById(id);
    }

    public Enterprise saveEnterprise(Enterprise enterpriseData) {
        return enterpriseRepository.save(enterpriseData);
    }

    public Enterprise update(Long id, Enterprise enterpriseData) {
        if (!enterpriseRepository.existsById(id)){
            throw new RuntimeException("Enterprise with id " +id+" not found.");
        }
        enterpriseData.setId(id);
        return enterpriseRepository.save(enterpriseData);
    }

    public void deleteById(Long id) {
        if (!enterpriseRepository.existsById(id)){
            throw new RuntimeException("Enterprise not found");
        }
        enterpriseRepository.deleteById(id);
    }
}
