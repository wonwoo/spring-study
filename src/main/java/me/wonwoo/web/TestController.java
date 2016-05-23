package me.wonwoo.web;

import org.omg.SendingContext.RunTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonwoo on 2016. 5. 23..
 */
@RestController
public class TestController {

  @GetMapping("/hello")
  public String helloGet() {
    if(true){
      throw new RuntimeException();
    }
    return "hello get";
  }

  @PostMapping("/hello")
  public String helloPost() {
    return "hello post";
  }
}