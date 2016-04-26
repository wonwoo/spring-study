package me.wonwoo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by wonwoo on 2016. 4. 26..
 */
public class AsyncBean {

  @Async
  public Future<String> get() throws InterruptedException {
    System.out.println("sleep start");
    //오래 걸리는 작업 혹은 데이터베이스 조회
    TimeUnit.SECONDS.sleep(3);
    System.out.println("sleep end");
    return new AsyncResult<>("return");
  }

@Async
public void get(Handler<String> handler) throws InterruptedException {
  System.out.println("sleep start");
  //오래 걸리는 작업 혹은 데이터베이스 조회
  TimeUnit.SECONDS.sleep(3);
  System.out.println("sleep end");
  handler.handle("return");
}
}
