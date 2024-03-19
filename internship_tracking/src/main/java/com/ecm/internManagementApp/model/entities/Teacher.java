package com.ecm.internManagementApp.model.entities;

import com.ecm.internManagementApp.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    @NonNull
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
    private String fax;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "hiring_date")
    private LocalDate hiringDate;
    @Column(name = "departure_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate departureDate;

}
