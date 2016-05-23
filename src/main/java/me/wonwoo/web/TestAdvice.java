package me.wonwoo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * Created by wonwoo on 2016. 5. 23..
 */

@RestControllerAdvice
public class TestAdvice {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleDuplicateKeyException(Exception e) throws IOException {
    return "exception";
  }
}
