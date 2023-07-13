package com.agm.applicant.Repository;

import com.agm.applicant.Model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDB extends JpaRepository<UserModel, Long>{
  UserModel findByUsername(String username);
}