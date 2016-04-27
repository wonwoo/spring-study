package me.wonwoo.jpa;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 4. 27..
 */

/**
 * spring.jpa.hibernate.ddl-auto=validate
 * test
 */
@Entity
@Data
public class Account {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String email;

}
