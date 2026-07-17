package com.lance.jobtracker;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data   //generates getters, setters, toString() etc.
@AllArgsConstructor     //generates constructor
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String role;
    private ApplicationStatus status;
    private LocalDate dateApplied;
    private String notes;
    private String contactName;
}
