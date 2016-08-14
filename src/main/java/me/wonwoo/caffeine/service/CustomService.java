package me.wonwoo.caffeine.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.wonwoo.caffeine.domain.Custom;
import me.wonwoo.caffeine.domain.CustomDto;
import me.wonwoo.caffeine.repository.CustomRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by wonwoo on 2016. 8. 14..
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CustomService {

  private final CustomRepository customRepository;


  @Cacheable("findName")
  public Custom findByname(CustomDto.SearchCustom name){
    log.info("findByname : {} ", name);
    return customRepository.findByname(name.getName());
  }
}
