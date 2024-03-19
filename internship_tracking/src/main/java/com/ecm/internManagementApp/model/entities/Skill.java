package com.ecm.internManagementApp.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skill", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NonNull
    private String code;
    @NonNull
    private String label;
    private String description;

    @OneToMany(mappedBy = "skill")
    private Set<InternshipType> internshipTypes;
}
