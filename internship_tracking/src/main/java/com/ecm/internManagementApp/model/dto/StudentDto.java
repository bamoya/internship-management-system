package com.ecm.internManagementApp.model.dto;

import com.ecm.internManagementApp.model.entities.Promo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    private String phone;
    private Promo promo;
}
