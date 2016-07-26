package me.wonwoo.validate;

import lombok.Data;

/**
 * Created by wonwoo on 2016. 7. 26..
 */
@Data
public class Customer {

  private String name;

  private int age;

  @MobilePhone
  private String mobilePhone;
}
