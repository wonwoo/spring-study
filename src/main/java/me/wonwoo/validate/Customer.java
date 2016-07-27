package me.wonwoo.validate;

import lombok.Data;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

/**
 * Created by wonwoo on 2016. 7. 26..
 */
@Data
public class Customer {

  private String name;

  private int age;

  @MobilePhone(message = "번호가 아닙니다.")
  private String mobilePhone;

  @AssertTrue(message = "나이는 0보다 커야 하며 150보다 작아야 합니다.")
  public boolean isValidAge(){
    return age > 0 && age < 150;
  }

  @AssertFalse(message = "name은 null이 아니여야 합니다")
  public boolean isValidName(){
    return name == null;
  }
}
