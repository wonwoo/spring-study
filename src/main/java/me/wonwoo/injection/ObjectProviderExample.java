package me.wonwoo.injection;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by wonwoo on 2016. 11. 28..
 */
@Configuration
public class ObjectProviderExample {

  @Configuration
  public static class Provider {

//    public Provider(ObjectFactory<BeanClass> factory) {
//      BeanClass object = factory.getObject();
//      System.out.println(object);
//    }

    public Provider(ObjectProvider<BeanClass> provider) {
      BeanClass ifAvailable = provider.getIfAvailable();
//      BeanClass ifUnique = provider.getIfUnique();
      System.out.println(ifAvailable);
//      System.out.println(ifUnique);
    }
  }

  @Bean
  @Primary
  public BeanClass beanClass() {
    return new BeanClass("wonwoo");
  }
  @Bean
  public BeanClass beanClass1() {
    return new BeanClass("wonwoo1");
  }


  private static class BeanClass {
    private final String name;

    public BeanClass(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      final StringBuffer sb = new StringBuffer("BeanClass{");
      sb.append("name='").append(name).append('\'');
      sb.append('}');
      return sb.toString();
    }
  }
}
