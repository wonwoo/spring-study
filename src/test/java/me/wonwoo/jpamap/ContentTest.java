package me.wonwoo.jpamap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wonwoo on 2016. 12. 21..
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ContentTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private ContentRepository repository;

  @Test
  public void oneToOneTest() {
    Content content = new Content("title", new ContentDetail("content text"));
    final Content persist = entityManager.persist(content);
    entityManager.detach(persist);
    final Content result = repository.findOne(persist.getId());
    final ContentDetail contentDetail = result.getContentDetail();
  }
}

