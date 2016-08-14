package me.wonwoo.caffeine.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 8. 14..
 */

@Getter
@Entity
public class Custom {

  @Id @GeneratedValue
  private Long id;

  private String name;

  Custom(){

  }

  public Custom(String name){
    this.name = name;
  }
}

