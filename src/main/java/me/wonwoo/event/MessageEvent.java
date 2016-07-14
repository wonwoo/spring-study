package me.wonwoo.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by wonwoo on 2016. 7. 14..
 */
public class MessageEvent extends ApplicationEvent {

  private String msg;
  public MessageEvent(Object source, String msg) {
    super(source);
    this.msg = msg;
  }

  public String getMessage() {
    return msg;
  }
}