package me.wonwoo.jpa.service;

import me.wonwoo.jpa.Account;
import me.wonwoo.jpa.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created by wonwoo on 2016. 5. 16..
 */

@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Transactional(readOnly = false)
  public Account save(Account account) {

    boolean currentTransactionReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
    System.out.println(currentTransactionReadOnly);
    String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
    System.out.println(currentTransactionName);
    Account save = accountRepository.save(account);
//    if(true){
//      throw new RuntimeException();
//    }
    return save;
  }

  @Transactional
  public Account save1(Account account) {
    boolean currentTransactionReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
    String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
    System.out.println(currentTransactionName);

    System.out.println(currentTransactionReadOnly);
//    Account save = accountRepository.save(account);
//    Account account1 = new Account();
//    account1.setName("kevin");
//    Account save1 = accountRepository.save(account1);
//    if(true){
//      throw new RuntimeException();
//    }
    Account save = accountRepository.save(account);
    Account account1 = new Account();
    account1.setName("kevin");
    Account save1 = accountRepository.save(account1);
    return save;
  }
}
