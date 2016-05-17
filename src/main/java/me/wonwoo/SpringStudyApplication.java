package me.wonwoo;

import me.wonwoo.jpa.tx.JpaTransactionManager;
import me.wonwoo.jpa.tx.OpenEntityManagerInViewInterceptorTx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
//@EnableAsync
public class SpringStudyApplication {


	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean
	public OpenEntityManagerInViewInterceptorTx openEntityManagerInViewInterceptor(){
		return new OpenEntityManagerInViewInterceptorTx();
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ConfigurableApplicationContext run = SpringApplication.run(SpringStudyApplication.class, args);
//		AsyncBean asyncBean = run.getBean(AsyncBean.class);
//
//    List<Future<String>> futures = new ArrayList<>();

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
//    Future<String> stringFuture = asyncBean.get();
//    System.out.println("비동기");
//    stringFuture.get();
//    System.out.println("end");
//    run.close();
	}
//
//  @Bean
//  public AsyncBean factoryBean(){
//    return new AsyncBean();
//  }
}

