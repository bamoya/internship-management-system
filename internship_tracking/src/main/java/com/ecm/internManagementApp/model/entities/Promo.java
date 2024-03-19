package com.ecm.internManagementApp.model.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "promo", uniqueConstraints = @UniqueConstraint(columnNames = "promo_year"))
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    @Column(name = "promo_year")
    private int promoYear;
    @Nullable
    @Column(name = "total_registered")
    private int totalRegistered;
    @Nullable
    @Column(name = "total_integrated")
    private int totalIntegrated;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacherDirector;

}