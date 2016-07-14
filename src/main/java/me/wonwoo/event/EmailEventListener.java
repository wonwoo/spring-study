package me.wonwoo.event;

import org.springframework.context.ApplicationListener;

/**
 * Created by wonwoo on 2016. 7. 14..
 */
public class EmailEventListener implements ApplicationListener<MessageEvent> {

  @Override
  public void onApplicationEvent(MessageEvent event) {
    System.out.println("EmailEventListener : " + event.getMessage());
  }

}