package me.wonwoo.event;

import org.springframework.context.ApplicationListener;

/**
 * Created by wonwoo on 2016. 7. 14..
 */
public class SmsEventListener implements ApplicationListener<MessageEvent> {

  public void onApplicationEvent(MessageEvent event) {
    System.out.println("SmsEventListener : " + event.getMessage());
  }
}