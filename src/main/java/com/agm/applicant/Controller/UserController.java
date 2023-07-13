package com.agm.applicant.Controller;

import java.util.HashMap;

import com.agm.applicant.Model.UserModel;
import com.agm.applicant.Service.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping(value = "/sign-up")
  public ResponseEntity<?> registerUser(@Valid @RequestBody UserModel user, BindingResult bindingResult) {
    HashMap<String, String> map = new HashMap<String, String>();
    if (bindingResult.hasFieldErrors()) {
      map.put("message", "Invalid Request!");
      return ResponseEntity.badRequest().body(map);
    }

    if (userService.getUserByUsername(user.getUsername()) != null) {
      map.put("message", "Email already registered!");
      return ResponseEntity.status(HttpStatus.CONFLICT).body(map);
    }
    userService.createUser(user);
    map.put("message", "Account created successfully!");
    return ResponseEntity.status(HttpStatus.CREATED).body(map);
  }

}
