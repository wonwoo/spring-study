package me.wonwoo.jpamap;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 12. 21..
 */
@Entity
@Data
public class ContentSetting {
  @Id @GeneratedValue
  private Long id;

  private String setting;

  @OneToOne(fetch = FetchType.LAZY)
  private Content content;
}
