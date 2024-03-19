package com.ecm.internManagementApp.repository;

import com.ecm.internManagementApp.model.entities.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Long> {
    Optional<Promo> findByPromoYear(int year);
    boolean existsByPromoYear(int year);
}
