package me.wonwoo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wonwoo on 2016. 5. 29..
 */
@Configuration
public class BeanPostProcessorTest implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

    return bean;
  }

@Override
public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
  if("initBean".equals(beanName)){
    InitBean initBean = (InitBean) bean;
    initBean.setName("wonwoo");
  }
  return bean;
}
}
