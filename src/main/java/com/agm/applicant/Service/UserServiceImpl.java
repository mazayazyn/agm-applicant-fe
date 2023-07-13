package com.agm.applicant.Service;

import com.agm.applicant.Model.CandidateModel;
import com.agm.applicant.Model.Role;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.agm.applicant.Model.UserModel;
import com.agm.applicant.Repository.UserDB;
import com.agm.applicant.Repository.CandidateDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDB userDB;

  @Autowired
  private CandidateDB candidateDb;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public String encryptPassword(String password) {
    return passwordEncoder.encode(password);
  }

  @Override
  public UserModel createUser(UserModel user) {
    LocalDateTime now = LocalDateTime.now();
    user.setCreatedAt(now);
    user.setUpdatedAt(now);
    user.setRole(Role.CANDIDATE);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    CandidateModel candidate = new CandidateModel();
    candidate.setUser(user);
    candidateDb.save(candidate);
    return userDB.save(user);
  }

  @Override
  public UserModel getUserByUsername(String username) {
    return userDB.findByUsername(username);
  }
}
