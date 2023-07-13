package com.agm.applicant.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class JwtResponse {
  private String token;
  private String refreshToken;
  private String type = "Bearer";
  private String username;
  private String role;
}
