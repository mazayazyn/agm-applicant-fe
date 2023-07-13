package com.agm.applicant.Repository;

import com.agm.applicant.Model.VacancyModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyDB extends JpaRepository<VacancyModel, Long>{
  @Query(value = "select id, title, updatedAt, status from VacancyModel order by updatedAt desc", countQuery = "select count(*) from VacancyModel")
  Page<VacancyModel> findForAdminDasboard(Pageable pageable);
}
