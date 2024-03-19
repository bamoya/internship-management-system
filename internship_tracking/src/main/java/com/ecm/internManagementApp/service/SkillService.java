package com.ecm.internManagementApp.service;

import com.ecm.internManagementApp.model.entities.Skill;
import com.ecm.internManagementApp.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    @Autowired
    SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public boolean existsById(Long id) {
        return skillRepository.existsById(id);
    }

    public Optional<Skill> getSkillById(Long id) {
        if (!skillRepository.existsById(id)){
            throw new RuntimeException("Skill by id "+id+" not found");
        }
        return skillRepository.findById(id);
    }

    public boolean existsByCode(String code) {
        return skillRepository.existsByCode(code);
    }

    public Skill getSkillByCode(String code) {
        if (!skillRepository.existsByCode(code)){
            throw new RuntimeException("Skill with code "+code+" not found.");
        }
        return skillRepository.getSkillByCode(code);
    }

    public Skill saveSkill(Skill skillData) {
        return skillRepository.save(skillData);
    }

    public void deleteSkill(Long id) {
        if (!skillRepository.existsById(id)){
            throw new RuntimeException("Skill by id "+id+" not found.");
        }
        skillRepository.deleteById(id);
    }
}
