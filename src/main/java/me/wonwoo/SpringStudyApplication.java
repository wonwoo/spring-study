package me.wonwoo;

import me.wonwoo.async.AsyncBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class SpringStudyApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ConfigurableApplicationContext run = SpringApplication.run(SpringStudyApplication.class, args);
		AsyncBean asyncBean = run.getBean(AsyncBean.class);

    List<Future<String>> futures = new ArrayList<>();

//    for(int i = 0; i < 100; i++){
//      Future<String> stringFuture = bean.get();
//      futures.add(stringFuture);
//    }
//    futures.stream().forEach(i -> {
//      String s = null;
//      try {
//        s = i.get();
//      } catch (InterruptedException e) {
//      } catch (ExecutionException e) {
//      }
//      System.out.println(s);
//    });

//    asyncBean.get(i -> System.out.println(i));
    Future<String> stringFuture = asyncBean.get();
    System.out.println("비동기");
//    stringFuture.get();
    System.out.println("end");
//    run.close();
	}

  @Bean
  public AsyncBean factoryBean(){
    return new AsyncBean();
  }
}

