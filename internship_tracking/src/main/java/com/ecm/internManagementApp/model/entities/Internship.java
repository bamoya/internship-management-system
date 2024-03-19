package com.ecm.internManagementApp.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "internship")
@AllArgsConstructor
@NoArgsConstructor
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "start_date")
    private Date startDate;
    @NonNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "end_date")
    private Date endDate;

    //relationships
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "internship")
    private Set<InternshipType> internshipTypes;
}
