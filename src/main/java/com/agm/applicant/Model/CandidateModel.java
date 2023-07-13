package com.agm.applicant.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "nc_zde2__candidates")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"user", "hibernateLazyInitializer"})
public class CandidateModel implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(referencedColumnName = "id", name = "user_id")
  private UserModel user;

  private String industry;

  private String yearsOfExperience;

  private Long currentSalary;

  private String jobLevel;

  private String jobPosition;

  private LocalDateTime updatedAt;

  @Lob
  private byte[] cv;

  private String pdfName;
}
