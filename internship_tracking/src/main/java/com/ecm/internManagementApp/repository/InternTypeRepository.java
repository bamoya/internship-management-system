package com.ecm.internManagementApp.repository;

import com.ecm.internManagementApp.model.entities.InternshipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternTypeRepository extends JpaRepository<InternshipType, Long> {
}
