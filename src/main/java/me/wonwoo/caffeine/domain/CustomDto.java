package me.wonwoo.caffeine.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by wonwoo on 2016. 8. 14..
 */
public class CustomDto {

//  @Getter
//  @Setter
  @Data
  public static class SearchCustom {
    private String name;
  }
}
