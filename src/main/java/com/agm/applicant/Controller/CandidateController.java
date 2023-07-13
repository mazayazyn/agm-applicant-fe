package com.agm.applicant.Controller;

import java.util.HashMap;

import javax.validation.Valid;

import com.agm.applicant.Model.CandidateModel;
import com.agm.applicant.Service.CandidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/candidate")
public class CandidateController {

  @Autowired
  private CandidateService candidateService;

  @GetMapping(value = "/profile/{id}")
  public ResponseEntity<?> registerUser(@PathVariable Long id) {
    return ResponseEntity.ok(candidateService.getCandidateProfile(id));
  }

  @PostMapping(value = "/profile")
  public ResponseEntity<?> registerUser(@Valid @RequestBody CandidateModel profile, BindingResult bindingResult) {
    if (bindingResult.hasFieldErrors()) {
      return ResponseEntity.badRequest().body("Invalid Request");
    }

    HashMap<String, String> map = new HashMap<String, String>();

    candidateService.saveProfile(profile);
    map.put("message", "Profile updated successfully!");
    return ResponseEntity.status(HttpStatus.CREATED).body(map);
  }
}
