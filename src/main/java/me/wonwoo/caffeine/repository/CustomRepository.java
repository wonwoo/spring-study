package me.wonwoo.caffeine.repository;

import me.wonwoo.caffeine.domain.Custom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wonwoo on 2016. 8. 14..
 */
public interface CustomRepository extends JpaRepository<Custom, Long> {
  Custom findByname(String name);
}
