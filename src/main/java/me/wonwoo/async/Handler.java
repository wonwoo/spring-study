package me.wonwoo.async;

/**
 * Created by wonwoo on 2016. 4. 26..
 */
public interface Handler<E> {
  void handle(E e);
}
