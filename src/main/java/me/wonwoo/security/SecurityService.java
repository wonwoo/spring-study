package me.wonwoo.security;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Created by wonwoo on 2016. 9. 22..
 */
@Service
public class SecurityService {

  @PreAuthorize("#oauth2.hasScope('read')")
  public User userRead(){
    return new User("wonwoo");
  }

  @PreAuthorize("#oauth2.hasScope('write')")
  public User userWrite(){
    return new User("wonwoo");
  }

  @PostAuthorize("(returnObject == 'good')")
  public String username(String name) {
    if("wonwoo".equals(name)){
      return "good";
    }
    return "bad";
  }
}
