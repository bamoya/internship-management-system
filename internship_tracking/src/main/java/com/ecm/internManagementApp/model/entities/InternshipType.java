package com.ecm.internManagementApp.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "internship_skill")
public class InternshipType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "intenship_id")
    private Internship internship;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;



}
