package me.wonwoo.mybatis.controller;

import me.wonwoo.mybatis.dao.AccountDao;
import me.wonwoo.mybatis.domain.Account;
import me.wonwoo.mybatis.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonwoo on 2016. 8. 6..
 */
@RestController("accountCtrl")
public class AccountController {

  @Autowired
  private AccountDao accountDao;

  @Autowired
  private AccountMapper accountMapper;

  @GetMapping("mybatisTest")
  public Account getAccount(@RequestParam String name){
    return accountDao.findByname(name);
  }

  @GetMapping("mybatisEamil")
  public Account mybatisEamil(@RequestParam String email){
    return accountMapper.findByemail(email);
  }
  @GetMapping("/{id}")
  public Account mybatisId(@PathVariable Long id){
    return accountMapper.findById(id);
  }
}
