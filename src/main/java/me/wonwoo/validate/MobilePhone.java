package me.wonwoo.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wonwoo on 2016. 7. 26..
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobilePhoneValidator.class)
public @interface MobilePhone {

  String message() default "{mobilePhone}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
