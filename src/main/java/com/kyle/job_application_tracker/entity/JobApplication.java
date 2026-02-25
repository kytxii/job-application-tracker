package com.kyle.job_application_tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "applications")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String position;
    private String location;
    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate appliedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
