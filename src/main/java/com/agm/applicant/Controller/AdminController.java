package com.agm.applicant.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.agm.applicant.Model.VacancyModel;
import com.agm.applicant.Service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
  @Autowired
  AdminService adminService;

  @PutMapping("/update-vacancy")
  public ResponseEntity<?> updateVacancy(@Valid @RequestBody VacancyModel vacancy, BindingResult bindingResult) {
    Map<String, String> map = new HashMap<String, String>();

    if (bindingResult.hasFieldErrors()) {
      map.put("message", "Invalid Request!");
      return ResponseEntity.badRequest().body(map);
    } else {
      adminService.updateVacancy(vacancy);
      map.put("message", "Resource updated successfully!");
      return ResponseEntity.ok(map);
    }
  }

  @GetMapping("/get-vacancy/{id}")
  public ResponseEntity<?> getVacancy(@PathVariable Long id) {
    VacancyModel vacancy = adminService.getVacancyById(id);
    if (vacancy == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(vacancy);
  }

  @PutMapping("/publish-vacancy")
  public ResponseEntity<?> publishVacancy(@Valid @RequestBody VacancyModel vacancy, BindingResult bindingResult) {
    Map<String, String> map = new HashMap<String, String>();
    adminService.publishVacancy(vacancy);
    map.put("message", "Resource updated successfully!");
    return ResponseEntity.ok(map);
  }

  @PutMapping("/reject-vacancy")
  public ResponseEntity<?> rejectVacancy(@Valid @RequestBody VacancyModel vacancy, BindingResult bindingResult) {
    Map<String, String> map = new HashMap<String, String>();
    adminService.rejectVacancy(vacancy);
    map.put("message", "Resource updated successfully!");
    return ResponseEntity.ok(map);
  }

  @GetMapping("/get-dashboard")
  public ResponseEntity<?> getDashboard(@RequestParam(defaultValue = "0") int page) {
    Map<String, Object> map = new HashMap<>();
    Page<VacancyModel> pages = adminService.getDashboard(page);
    List<VacancyModel> vacancies = pages.getContent();
    map.put("vacancies", vacancies);
    map.put("currentPage", pages.getNumber());
    map.put("totalItems", pages.getTotalElements());
    map.put("totalPages", pages.getTotalPages());
    return ResponseEntity.ok().body(map);
  }

}
