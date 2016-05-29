package me.wonwoo.web;

import me.wonwoo.processor.InitBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonwoo on 2016. 5. 23..
 */
@RestController
public class TestController {

  @GetMapping("/hello")
  public String helloGet() {
    System.out.println(initBean.getName());
    if(true){
      throw new RuntimeException();
    }
    return "hello get";
  }

  @Autowired
  private InitBean initBean;

  @PostMapping("/hello")
  public String helloPost() {
    return "hello post";
  }
}