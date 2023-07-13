package com.agm.applicant.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.agm.applicant.Model.VacancyModel;
import com.agm.applicant.Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
  @Autowired
  ClientService clientService;

  @PostMapping("/create-vacancy")
  public ResponseEntity<?> createVacancy(@Valid @RequestBody VacancyModel vacancy, BindingResult bindingResult) {
    Map<String, String> map = new HashMap<String, String>();

    if (bindingResult.hasFieldErrors()) {
      map.put("message", "Invalid Request!");
      return ResponseEntity.badRequest().body(map);
    } else {
      clientService.createVacancy(vacancy);
      map.put("message", "Resource created successfully!");
      return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }
  }
  
}
