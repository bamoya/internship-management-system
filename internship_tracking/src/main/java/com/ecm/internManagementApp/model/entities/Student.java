package com.ecm.internManagementApp.model.entities;

import com.ecm.internManagementApp.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id" ,nullable = false, updatable = false)
    private Long id;
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    @Column(name = "postal_code")
    private String postalCode;
    @NonNull
    private String city;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NonNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promo_id")
    private Promo promo;
}
