package me.wonwoo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wonwoo on 2016. 5. 29..
 * PreserveErrorControllerTargetClassPostProcessor
 */
@Configuration
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    String[] beanNames = beanFactory.getBeanDefinitionNames();
    for(String beanName: beanNames){
      System.out.println(beanName);
    }
  }
}
