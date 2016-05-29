package me.wonwoo.processor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by wonwoo on 2016. 5. 29..
 */
@Component
public class InitBean implements InitializingBean {

  private String name;

  public InitBean(){
    System.out.println("init");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println(name);
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
