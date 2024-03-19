package com.ecm.internManagementApp.model.entities;


import com.ecm.internManagementApp.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@Table(name = "tutor")
@AllArgsConstructor
@NoArgsConstructor
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Assuming a typical auto-incrementing ID

    @Column(name = "first_name", length = 50)
    @NonNull
    private String firstName;

    @Column(name = "last_name", length = 50)
    @NonNull
    private String lastName;

    @Enumerated(EnumType.STRING)
    @NonNull
    private Gender gender;

    @Column(name = "phone_number")
    @NonNull
    private Integer phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY) // Adjust fetch type if needed
    @JoinColumn(name = "entreprise_id")
    private Enterprise enterprise;

}