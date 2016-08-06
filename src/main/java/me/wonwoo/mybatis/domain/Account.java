package me.wonwoo.mybatis.domain;

import lombok.Data;

/**
 * Created by wonwoo on 2016. 8. 6..
 */

@Data
public class Account {
  private Long id;

  private String name;

  private String email;
}
