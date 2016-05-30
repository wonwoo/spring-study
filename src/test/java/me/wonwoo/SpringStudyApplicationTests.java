package me.wonwoo;

import me.wonwoo.jpa.Account;
import me.wonwoo.jpa.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
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

  @Autowired
  private AsyncRestTemplate asyncRestTemplate;

  @Test
  public void asyncRestTemplateTest() throws InterruptedException, ExecutionException {
    ListenableFuture<ResponseEntity<Map>> entity = asyncRestTemplate.getForEntity("https://httpbin.org/get", Map.class);

    ResponseEntity<Map> responseEntity = entity.get();
    System.out.println(responseEntity.getStatusCode());
    System.out.println(responseEntity.getStatusCode());

    entity.addCallback(result -> {
      System.out.println(result.getStatusCode());
      System.out.println(result.getBody());
    }, ex -> System.out.println(ex.getStackTrace()));
    System.out.println("asyncRestTemplateTest");
    TimeUnit.SECONDS.sleep(8);
  }
}
