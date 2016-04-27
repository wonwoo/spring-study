package me.wonwoo.aspect;

import org.springframework.cglib.core.KeyFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wonwoo on 2016. 4. 27..
 */
public class CGlibInterceptor implements MethodInterceptor{

  public static void main(String[] args) {
    Twice twice = (Twice) Enhancer.create(Twice.class, new CGlibInterceptor());
    int t = twice.twice(5);
    System.out.println(t);

    MyFactory f = (MyFactory) KeyFactory.create(MyFactory.class);
    Object key1 = f.newInstance(20, new char[]{ 'a', 'b' }, "hello");
    Object key2 = f.newInstance(20, new char[]{ 'a', 'b' }, "hello");
    Object key3 = f.newInstance(20, new char[]{ 'a', '_' }, "hello");
    System.out.println(key1.equals(key2));
    System.out.println(key2.equals(key3));
  }
  @Override
  public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
    System.out.println("start");
    Object returnValue = methodProxy.invokeSuper(object, args);
    System.out.println("end");
    return returnValue;
  }

  static class Twice  {
    public int twice(int x) {
      return x * 2;
    }
  }
  private interface MyFactory {
    Object newInstance(int a, char[] b, String d);
  }
}
