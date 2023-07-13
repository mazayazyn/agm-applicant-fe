package com.agm.applicant.Repository;

import com.agm.applicant.Model.CandidateModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDB extends JpaRepository<CandidateModel, Long> {
}
