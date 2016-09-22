package me.wonwoo.validate;

import lombok.RequiredArgsConstructor;
import me.wonwoo.web.GetMapping;
import me.wonwoo.web.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by wonwoo on 2016. 7. 26..
 */
@RestController
@RequiredArgsConstructor
public class CustomerController {

//  private final CustomerValidate customerValidate;
//
//  @InitBinder
//  private void initBinder(WebDataBinder dataBinder){
//    dataBinder.setValidator(customerValidate);
//  }

//  @PostMapping("/validTest/{id}")
//  public void save(@RequestBody @Valid Customer customer, BindingResult bindingResult){
//    if(bindingResult.hasErrors()){
//      FieldError fieldError = bindingResult.getFieldError();
//      throw new RuntimeException(fieldError.getDefaultMessage());
//    }
//  }

//  @PostMapping("/validTest1")
//  public void save1(@RequestBody Customer customer, BindingResult bindingResult){
//    customerValidate.validate(customer, bindingResult);
//    if(bindingResult.hasErrors()){
//      FieldError fieldError = bindingResult.getFieldError();
//      throw new RuntimeException(fieldError.getDefaultMessage());
//    }
//  }
}
