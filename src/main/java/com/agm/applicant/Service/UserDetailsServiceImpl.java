package com.agm.applicant.Service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import com.agm.applicant.Model.UserModel;
import com.agm.applicant.Repository.UserDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserDB userDB;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserModel user = userDB.findByUsername(username);
    Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
    grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
        grantedAuthorities);
  }
}
