package me.wonwoo.web;

import lombok.Data;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * Created by wonwoo on 2016. 5. 23..
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = RequestMethod.GET)
public @interface GetMapping {

  @AliasFor(annotation = RequestMapping.class)
  String name() default "";

  @AliasFor(annotation = RequestMapping.class)
  String[] value() default {};


  @AliasFor(annotation = RequestMapping.class)
  String[] path() default {};


  @AliasFor(annotation = RequestMapping.class)
  String[] params() default {};

  @AliasFor(annotation = RequestMapping.class)
  String[] headers() default {};

  @AliasFor(annotation = RequestMapping.class)
  String[] produces() default {};

}