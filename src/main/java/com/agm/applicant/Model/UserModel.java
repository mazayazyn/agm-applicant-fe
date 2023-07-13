package com.agm.applicant.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "nc_zde2__users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;

  private String lastName;

  @Column(unique = true)
  private String username;

  private String password;

  private String gender;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthday;

  private String phone;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
  private CandidateModel candidateProfile;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
  private ClientModel clientProfile;

  @Enumerated(EnumType.STRING)
  private Role role;
}
