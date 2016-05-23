package me.wonwoo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.*;

/**
 * Created by wonwoo on 2016. 5. 23..
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ResponseStatus(HttpStatus.BAD_REQUEST)
public @interface ResponseStatusBadRequest {
  String reason() default "";
}
