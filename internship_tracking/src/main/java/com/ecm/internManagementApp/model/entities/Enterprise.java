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
@Table(name = "enterprise" ,uniqueConstraints = @UniqueConstraint(columnNames = "siret")) // Use the same table name as the Django model
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @NonNull
    private Integer siret;

    @Column(name = "legal_form")
    @NonNull
    private String legalForm;

    @Column(name = "business_name")
    @NonNull
    private String businessName;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "city")
    @NonNull
    private String city;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "fax")
    private Integer fax;

    @Column(name = "manager")
    private String manager;

    @Column(name = "manager_phone")
    private Integer managerPhone;


}