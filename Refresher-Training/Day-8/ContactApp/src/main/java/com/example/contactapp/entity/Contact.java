package com.example.contactapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "contact_firstname", nullable = false, length = 50)
    private String firstName;

    @Column(name = "contact_lastname", nullable = false, length = 50)
    private String lastName;

    @Column(name = "contact_email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "contact_phone", nullable = false, unique = true, length = 15)
    private String phone;

    @Column(name = "contact_address", nullable = false, length = 150)
    private String address;

    @Column(name = "contact_city", nullable = false, length = 50)
    private String city;

    @Column(name = "contact_state", nullable = false, length = 50)
    private String state;

    @Column(name = "contact_country", nullable = false, length = 50)
    private String country;

    @Column(name = "contact_createdAt", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "contact_updatedAt")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}