package com.agm.applicant.Service;

import com.agm.applicant.Model.CandidateModel;

public interface CandidateService {
  CandidateModel saveProfile(CandidateModel profile);
  CandidateModel getCandidateProfile(Long id);
}
