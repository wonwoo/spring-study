package me.wonwoo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * Created by wonwoo on 2016. 7. 25..
 */
@Slf4j
public class BlackLogNotifier implements ApplicationListener<BlackListEvent> ,Ordered{

  @Override
  public void onApplicationEvent(BlackListEvent event) {
    log.info("black log");
  }

  @Override
  public int getOrder() {
    return HIGHEST_PRECEDENCE;
  }
}
