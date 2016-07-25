package me.wonwoo.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * Created by wonwoo on 2016. 7. 25..
 */
public class EmailService implements ApplicationEventPublisherAware {

  private List<String> blackList;
  private ApplicationEventPublisher publisher;

  public void setBlackList(List<String> blackList) {
    this.blackList = blackList;
  }

  public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  public void sendEmail(String address, String text) {
    if (blackList.contains(address)) {
      BlackListEvent event = new BlackListEvent(this, address, text);
      publisher.publishEvent(event);
      return;
    }
    // send email...
  }
}