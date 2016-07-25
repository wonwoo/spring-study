package me.wonwoo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * Created by wonwoo on 2016. 7. 25..
 */
@Slf4j
public class AnnotationListener {

  private String notificationAddress;

  public void setNotificationAddress(String notificationAddress) {
    this.notificationAddress = notificationAddress;
  }

//  @EventListener(condition = "#event.text == 'foo'")
  @EventListener
  @Async
  public void processBlackListEvent(BlackListEvent event) {
    log.info("이벤트 발생 시간 : {}", event.getTimestamp());
    log.info("관리자에게 알리자 : {} " ,notificationAddress);
  }
}


