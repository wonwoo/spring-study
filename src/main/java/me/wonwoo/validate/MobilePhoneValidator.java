package me.wonwoo.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by wonwoo on 2016. 7. 26..
 */
public class MobilePhoneValidator implements ConstraintValidator<MobilePhone, String> {

  @Override
  public void initialize(MobilePhone constraintAnnotation) {
    System.out.println(constraintAnnotation);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    System.out.println(context);
    if(value == null) {
      return false;
    }
    return value.matches("[0-9()-]*");
  }
}
