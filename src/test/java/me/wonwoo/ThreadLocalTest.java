package me.wonwoo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by wonwoo on 2016. 6. 2..
 */
public class ThreadLocalTest implements Runnable {

  @Data
  @AllArgsConstructor
  static class UserInfo {
    private String name;
  }
  private static final ThreadLocal<UserInfo> userInfoThreadLocal1 = ThreadLocal.withInitial(
    () -> new UserInfo("wonwoo")
  );

  private static final ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<UserInfo>() {
    @Override
    protected UserInfo initialValue() {
      return new UserInfo("wonwoo");
    }
  };

  @Override
  public void run() {
    UserInfo userInfo = new UserInfo("wonwoo");
    System.out.println("Thread Name = " + Thread.currentThread().getName() + " default value = " + userInfo.getName());
//    userInfoThreadLocal.set(new UserInfo("kevin"));
    userInfo = new UserInfo("kevin");
    System.out.println("Thread Name = " + Thread.currentThread().getName() + "         value = " + userInfo.getName());
  }

//  private static UserInfo userInfoThreadLocal = new UserInfo("wonwoo");
//
//  @Override
//  public void run() {
//    System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + userInfoThreadLocal.getName());
//
//    userInfoThreadLocal = new UserInfo("kevin");
//
//    System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + userInfoThreadLocal.getName());
//  }


  public static void main(String[] args) throws InterruptedException {
    ThreadLocalTest obj = new ThreadLocalTest();
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(obj, "" + i);
      t.start();
    }
  }

//  public static void main(String[] args) {
//    A a = new A();
//    a.a();
//  }
}

class A {
  public void a() {
    ThreadLocalClass.local.set("wonwoo");
    B b = new B();
    b.b();
    ThreadLocalClass.local.remove();
  }
}

class B {
  public void b() {
    String str = ThreadLocalClass.local.get();
    System.out.println(str);
  }
}

class ThreadLocalClass {

  public static ThreadLocal<String> local = new ThreadLocal<>();
}