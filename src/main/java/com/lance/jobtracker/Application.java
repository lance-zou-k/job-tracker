package com.lance.jobtracker;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data   //generates getters, setters, toString() etc.
@AllArgsConstructor     //generates constructor
public class Application {
    private String companyName;
    private String role;
    private ApplicationStatus status;
    private LocalDate dateApplied;
    private String notes;
    private String contactName;
    private Long id;
}
