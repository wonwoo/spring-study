package me.wonwoo;

import me.wonwoo.jpa.Account;
import me.wonwoo.jpa.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringStudyApplication.class)
public class SpringStudyApplicationTests {

	@Autowired
	private AccountService accountService;

	@Test
	public void contextLoads() {
		Account account = new Account();
		account.setEmail("test@test.com");
		account.setName("wonwoo");
		accountService.save1(account);
	}
}
