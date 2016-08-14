package me.wonwoo.caffeine;

import lombok.RequiredArgsConstructor;
import me.wonwoo.caffeine.domain.Custom;
import me.wonwoo.caffeine.repository.CustomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by wonwoo on 2016. 8. 14..
 */
@Component
@RequiredArgsConstructor
public class CustomData implements CommandLineRunner{

  private final CustomRepository customRepository;

  @Override
  public void run(String... args) throws Exception {
    customRepository.save(Arrays.asList(new Custom("wonwoo"),new Custom("test")));
  }
}
