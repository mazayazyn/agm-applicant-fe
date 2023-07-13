package com.agm.applicant.Service;

import com.agm.applicant.Model.UserModel;

public interface UserService {
  String encryptPassword(String password);
  UserModel createUser(UserModel user);
  UserModel getUserByUsername(String username);
}
