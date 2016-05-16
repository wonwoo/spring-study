package me.wonwoo.jpa.controller;

import me.wonwoo.jpa.Account;
import me.wonwoo.jpa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonwoo on 2016. 5. 16..
 */

@RestController
public class AccountController {

  @Autowired
  private AccountService accountService;

  @RequestMapping("/test")
  public Account account(){
    Account account = new Account();
    account.setEmail("test@test.com");
    account.setName("wonwoo");
    return accountService.save1(account);
  }
}
