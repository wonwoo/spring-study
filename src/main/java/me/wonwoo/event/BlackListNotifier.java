package me.wonwoo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * Created by wonwoo on 2016. 7. 25..
 */
@Slf4j
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

  private String notificationAddress;

  public void setNotificationAddress(String notificationAddress) {
    this.notificationAddress = notificationAddress;
  }

  @Override
  public void onApplicationEvent(BlackListEvent event) {
    log.info("이벤트 발생 시간 : {}", event.getTimestamp());
    log.info("관리자에게 알리자 : {} " ,notificationAddress);
    //
    // notify appropriate parties via notificationAddress...
  }

}