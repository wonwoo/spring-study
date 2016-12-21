package me.wonwoo.jpamap;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 12. 21..
 */
@Entity
@Data
@ToString(exclude = "content")
@EqualsAndHashCode(exclude = "content")
public class ContentDetail {

  @Id
  @GeneratedValue
  private Long id;

  private String text;

  @OneToOne(fetch = FetchType.LAZY)
  private Content content;

  ContentDetail() {
  }

  public ContentDetail(String text) {
    this.text = text;
  }
}
