package com.ecm.internManagementApp.repository;

import com.ecm.internManagementApp.model.entities.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<Internship, Long> {
}
