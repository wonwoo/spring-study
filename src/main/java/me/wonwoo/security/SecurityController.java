package me.wonwoo.security;

import me.wonwoo.web.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonwoo on 2016. 9. 22..
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

  private final SecurityService securityService;

  public SecurityController(SecurityService securityService) {
    this.securityService = securityService;
  }

  @GetMapping("/read")
  public User userRead(){
    return securityService.userRead();
  }
  @GetMapping("/write")
  public User userWrite(){
    return securityService.userWrite();
  }

  @GetMapping("/user/{name}")
  public String username(@PathVariable String name){
    return securityService.username(name);
  }
}
