package com.ecm.internManagementApp.repository;

import com.ecm.internManagementApp.model.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    boolean existsByCode(String code);

    Skill getSkillByCode(String code);
}
