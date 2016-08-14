package me.wonwoo;

import me.wonwoo.event.AnnotationListener;
import me.wonwoo.event.BlackListNotifier;
import me.wonwoo.event.BlackLogNotifier;
import me.wonwoo.event.EmailService;
import me.wonwoo.jpa.tx.JpaTransactionManager;
import me.wonwoo.jpa.tx.OpenEntityManagerInViewInterceptorTx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.AsyncRestTemplate;

import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@EnableAsync
@EnableCaching
public class SpringStudyApplication {

  @Bean
  public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  @Bean
  public OpenEntityManagerInViewInterceptorTx openEntityManagerInViewInterceptor() {
    return new OpenEntityManagerInViewInterceptorTx();
  }

  @Bean
  public AsyncRestTemplate asyncRestTemplate() {
    AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
    return asyncRestTemplate;
  }
//  @Bean
//  public EmailEventListener emailEventListener(){
//    return new EmailEventListener();
//  }
//  @Bean
//  public SmsEventListener smsEventListener(){
//    return new SmsEventListener();
//  }
//  @Bean
//  public Publisher publisher(){
//    return new Publisher();
//  }
//
//  @Autowired
//  private Publisher publisher;


  @Bean
  public EmailService emailService() {
    EmailService emailService = new EmailService();
    emailService.setBlackList(Arrays.asList("test@test.com", "wonwoo@test.com", "5151@test.com"));
    return emailService;
  }

  @Bean
  public BlackListNotifier blackListNotifier() {
    BlackListNotifier blackListNotifier = new BlackListNotifier();
    blackListNotifier.setNotificationAddress("admin@test.com");
    return blackListNotifier;
  }

  @Bean
  public BlackLogNotifier blackLogNotifier() {
    return new BlackLogNotifier();
  }

  @Bean
  public AnnotationListener annotationListener() {
    AnnotationListener annotationListener = new AnnotationListener();
    annotationListener.setNotificationAddress("admin@test.com");
    return annotationListener;
  }


//  @Bean
//  public CommandLineRunner commandLineRunner(){
//    return args -> {
//      publisher.publish("hello");
//      publisher.publish("hello123");
//    };
//  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ApplicationContext run = SpringApplication.run(SpringStudyApplication.class, args);
    EmailService bean = run.getBean(EmailService.class);
    bean.sendEmail("wonwoo@test.com", "hi wonwoo");
    System.out.println("tet123");

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

