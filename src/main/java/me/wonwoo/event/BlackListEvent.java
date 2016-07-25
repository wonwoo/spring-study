package me.wonwoo.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by wonwoo on 2016. 7. 25..
 */
public class BlackListEvent extends ApplicationEvent {

  private final String address;
  private final String text;

  public BlackListEvent(Object source, String address, String text) {
    super(source);
    this.address = address;
    this.text = text;
  }

  public String getText() {
    return text;
  }

  //other method
}