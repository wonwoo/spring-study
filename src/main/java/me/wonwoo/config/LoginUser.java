package me.wonwoo.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by wonwoo on 2016. 8. 5..
 */
@Getter
@RequiredArgsConstructor
public class LoginUser {
  private final String username;
  private final String name;
}
