package com.lance.jobtracker;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//@Data   generates getters, setters, toString() etc.
//changes: it conflicted with JPA's @ManyToOne, replacing @Data with getter and setter.
@Getter
@Setter
@AllArgsConstructor     //generates constructor
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
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
