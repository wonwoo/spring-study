package me.wonwoo.validate;

import lombok.RequiredArgsConstructor;
import me.wonwoo.web.GetMapping;
import me.wonwoo.web.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by wonwoo on 2016. 7. 26..
 */
@RestController
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerValidate customerValidate;

  @InitBinder
  private void initBinder(WebDataBinder dataBinder){
    dataBinder.setValidator(customerValidate);
  }

  @PostMapping("/validTest")
  public void save(@RequestBody @Valid Customer customer, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
      System.out.println(bindingResult.getFieldError().getDefaultMessage());
    }
  }
}
