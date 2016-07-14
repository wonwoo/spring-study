package me.wonwoo.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by wonwoo on 2016. 7. 14..
 */
public class Publisher implements ApplicationContextAware {

  private ApplicationContext applicationContext;
  public void setApplicationContext(ApplicationContext applicationContext)
    throws BeansException {
    this.applicationContext = applicationContext;

  }

  public void publish(String message) {
    applicationContext.publishEvent(new MessageEvent(this, message));
  }
}
