package com.agm.applicant.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "nc_zde2__vacancies")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacancyModel implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private LocalDateTime updatedAt;
  private int status;

  private String title;
  private LocalDate desiredDate;
  private String reportsTo;
  private String subordinates;
  private String workingTime;
  private String workingLocation;
  private String industry;
  private String yearsOfExperience;
  private String jobLevel;
  private String jobPosition;
  private Long startSalary;
  private Long endSalary;
  private String keyResponsibility;
  private String behaviouralCompetencies;
  private String organizationCulture;
  
  private String targetedCompanies;
  private String untargetedCompanies;
  private String salaryReview;
  private String bonusSystem;
  private String benefits;
}
