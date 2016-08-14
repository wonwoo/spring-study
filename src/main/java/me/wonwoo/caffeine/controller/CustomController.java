package me.wonwoo.caffeine.controller;

import lombok.RequiredArgsConstructor;
import me.wonwoo.caffeine.domain.Custom;
import me.wonwoo.caffeine.domain.CustomDto;
import me.wonwoo.caffeine.service.CustomService;
import me.wonwoo.web.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonwoo on 2016. 8. 14..
 */
@RestController
@RequiredArgsConstructor
public class CustomController {

  private final CustomService customService;

  @GetMapping("/custom")
  public Custom findByname(@ModelAttribute CustomDto.SearchCustom customDto){
    return customService.findByname(customDto);
  }
}
