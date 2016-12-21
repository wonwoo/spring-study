package me.wonwoo.jpamap;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.bytecode.internal.javassist.FieldHandled;
import org.hibernate.bytecode.internal.javassist.FieldHandler;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 12. 21..
 */
@Entity
@Data
@ToString(exclude = "contentDetail")
@EqualsAndHashCode(exclude = "contentDetail")
public class Content implements FieldHandled {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  @OneToOne(mappedBy = "content", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @LazyToOne(LazyToOneOption.NO_PROXY)
  private ContentDetail contentDetail;

  @OneToOne(mappedBy = "content", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @LazyToOne(LazyToOneOption.NO_PROXY)
  private ContentSetting contentSetting;

  private FieldHandler fieldHandler;

  Content() {
  }

  public Content(String title, ContentDetail contentDetail) {
    this.title = title;
    this.contentDetail = contentDetail;
    contentDetail.setContent(this);
  }

  public ContentDetail getContentDetail() {
    if (fieldHandler != null) {
      return (ContentDetail) fieldHandler.readObject(this, "contentDetail", this.contentDetail);
    }
    return contentDetail;
  }

  public void setContentDetail(ContentDetail contentDetail) {
    if (fieldHandler != null) {
      this.contentDetail = (ContentDetail) fieldHandler.writeObject(this, "contentDetail", this.contentDetail, contentDetail);
    } else {
      this.contentDetail = contentDetail;
    }
    if (this.contentDetail != null) {
      this.contentDetail.setContent(this);
    }
  }

  public ContentSetting getContentSetting() {
    if (fieldHandler != null) {
      return (ContentSetting) fieldHandler.readObject(this, "contentSetting", this.contentSetting);
    }
    return contentSetting;
  }

  public void setContentSetting(ContentSetting contentSetting) {
    if (fieldHandler != null) {
      this.contentSetting = (ContentSetting) fieldHandler.writeObject(this, "contentSetting", this.contentSetting, contentDetail);
    } else {
      this.contentSetting = contentSetting;
    }
    if (this.contentSetting != null) {
      this.contentSetting.setContent(this);
    }
  }

  @Override
  public void setFieldHandler(FieldHandler handler) {
    this.fieldHandler = handler;
  }

  @Override
  public FieldHandler getFieldHandler() {
    return fieldHandler;
  }
}
