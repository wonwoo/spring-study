package me.wonwoo.web;

import me.wonwoo.config.LoginUser;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonwoo on 2016. 8. 5..
 */
@RestController
public class UserController {

  @GetMapping("userTest")
  public LoginUser loginUser(LoginUser loginUser){
    return loginUser;
  }
}
