package com.agm.applicant.Service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.agm.applicant.Model.VacancyModel;
import com.agm.applicant.Repository.VacancyDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{
  @Autowired
  VacancyDB vacancyDB;

  @Override
  public VacancyModel createVacancy(VacancyModel vacancy) {
    LocalDateTime now = LocalDateTime.now();
    vacancy.setUpdatedAt(now);
    vacancy.setStatus(2);
    return vacancyDB.save(vacancy);
  }
  
}
