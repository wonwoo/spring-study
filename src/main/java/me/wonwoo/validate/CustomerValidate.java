package me.wonwoo.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by wonwoo on 2016. 7. 26..
 */
@Component
public class CustomerValidate implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return Customer.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    Customer customer = (Customer) target;
    if (customer.getAge() < 0) {
      errors.rejectValue("age", "negativevalue");
    } else if (customer.getAge() > 130) {
      errors.rejectValue("age", "too.darn.old");
    }
    System.out.println(customer);
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "Name is required!");
  }
}
