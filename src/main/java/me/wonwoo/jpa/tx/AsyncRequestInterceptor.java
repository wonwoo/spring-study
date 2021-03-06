package me.wonwoo.jpa.tx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

import javax.persistence.EntityManagerFactory;
import java.util.concurrent.Callable;

/**
 * study
 * Created by wonwoo on 2016. 5. 17..
 */
public class AsyncRequestInterceptor extends CallableProcessingInterceptorAdapter implements DeferredResultProcessingInterceptor {

  private static final Log logger = LogFactory.getLog(AsyncRequestInterceptor.class);

  private final EntityManagerFactory emFactory;

  private final org.springframework.orm.jpa.EntityManagerHolder emHolder;

  private volatile boolean timeoutInProgress;


  public AsyncRequestInterceptor(EntityManagerFactory emFactory, org.springframework.orm.jpa.EntityManagerHolder emHolder) {
    this.emFactory = emFactory;
    this.emHolder = emHolder;
  }


  @Override
  public <T> void preProcess(NativeWebRequest request, Callable<T> task) {
    bindSession();
  }

  public void bindSession() {
    this.timeoutInProgress = false;
    TransactionSynchronizationManager.bindResource(this.emFactory, this.emHolder);
  }

  @Override
  public <T> void postProcess(NativeWebRequest request, Callable<T> task, Object concurrentResult) {
    TransactionSynchronizationManager.unbindResource(this.emFactory);
  }

  @Override
  public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) {
    this.timeoutInProgress = true;
    return RESULT_NONE;  // give other interceptors a chance to handle the timeout
  }

  @Override
  public <T> void afterCompletion(NativeWebRequest request, Callable<T> task) throws Exception {
    closeAfterTimeout();
  }

  private void closeAfterTimeout() {
    if (this.timeoutInProgress) {
      logger.debug("Closing JPA EntityManager after async request timeout");
      EntityManagerFactoryUtils.closeEntityManager(emHolder.getEntityManager());
    }
  }


  // Implementation of DeferredResultProcessingInterceptor methods

  @Override
  public <T> void beforeConcurrentHandling(NativeWebRequest request, DeferredResult<T> deferredResult) {
  }

  @Override
  public <T> void preProcess(NativeWebRequest request, DeferredResult<T> deferredResult) {
  }

  @Override
  public <T> void postProcess(NativeWebRequest request, DeferredResult<T> deferredResult, Object result) {
  }

  @Override
  public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) {
    this.timeoutInProgress = true;
    return true;  // give other interceptors a chance to handle the timeout
  }

  @Override
  public <T> void afterCompletion(NativeWebRequest request, DeferredResult<T> deferredResult) {
    closeAfterTimeout();
  }

}
