package com.agm.applicant.Service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.agm.applicant.Model.CandidateModel;
import com.agm.applicant.Repository.CandidateDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

  @Autowired
  UserService userService;

  @Autowired
  CandidateDB candidateDB;

  // @Override
  // public CandidateModel saveProfile(CandidateProfileWrapper profile) {
  // if (profile.getPdf().isEmpty() == false) {
  // try {
  // byte[] cv = profile.getPdf().getBytes();
  // profile.getProfile().setCv(cv);
  // } catch (IOException e) {
  // e.printStackTrace();
  // }
  // }

  // String pdfName = profile.getPdf().getOriginalFilename();

  // profile.getProfile().setPdfName(pdfName);
  // LocalDateTime now = LocalDateTime.now();
  // profile.getProfile().setUpdatedAt(now);
  // profile.getProfile().setUser(userService.getUserByEmail(profile.getProfile().getUser().getEmail()));
  // return candidateDB.save(profile.getProfile());
  // }

  @Override
  public CandidateModel saveProfile(CandidateModel profile) {
    LocalDateTime now = LocalDateTime.now();
    profile.setUpdatedAt(now);
    profile.setUser(getCandidateProfile(profile.getId()).getUser());
    return candidateDB.save(profile);
  }

  @Override
  public CandidateModel getCandidateProfile(Long id) {
    return candidateDB.getById(id);
  }

}
