package com.agm.applicant.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import com.agm.applicant.Model.VacancyModel;
import com.agm.applicant.Repository.VacancyDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

  @Autowired
  VacancyDB vacancyDB;

  @Override
  public VacancyModel updateVacancy(VacancyModel vacancy) {
    LocalDateTime now = LocalDateTime.now();
    vacancy.setUpdatedAt(now);
    return vacancyDB.save(vacancy);
  }

  @Override
  public VacancyModel publishVacancy(VacancyModel vacancy) {
    LocalDateTime now = LocalDateTime.now();
    vacancy.setUpdatedAt(now);
    vacancy.setStatus(1);
    return vacancyDB.save(vacancy);
  }

  @Override
  public VacancyModel rejectVacancy(VacancyModel vacancy) {
    LocalDateTime now = LocalDateTime.now();
    vacancy.setUpdatedAt(now);
    vacancy.setStatus(3);
    return vacancyDB.save(vacancy);
  }

  @Override
  public Page<VacancyModel> getDashboard(int page) {
    Pageable paging = PageRequest.of(page, 10);
    return vacancyDB.findForAdminDasboard(paging);
  }

  @Override
  public VacancyModel getVacancyById(Long id) {
    Optional<VacancyModel> vacancy = vacancyDB.findById(id);
        if (vacancy.isPresent()) {
            return vacancy.get();
        }
        return null;
  }
  
}
