package com.agm.applicant.Service;

import com.agm.applicant.Model.VacancyModel;

import org.springframework.data.domain.Page;

public interface AdminService {
  VacancyModel updateVacancy(VacancyModel vacancy);
  VacancyModel publishVacancy(VacancyModel vacancy);
  VacancyModel rejectVacancy(VacancyModel vacancy);
  Page<VacancyModel> getDashboard(int page);
  VacancyModel getVacancyById(Long id);
}
