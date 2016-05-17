package me.wonwoo.jpa.tx;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.context.request.async.WebAsyncUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 * study
 * Created by wonwoo on 2016. 5. 17..
 */
public class OpenEntityManagerInViewInterceptorTx extends OpenEntityManagerInViewInterceptor {

  @Override
  public void preHandle(WebRequest request) throws DataAccessException {
    String participateAttributeName = getParticipateAttributeName();

    WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);
    if (asyncManager.hasConcurrentResult()) {
      if (applyCallableInterceptor(asyncManager, participateAttributeName)) {
        return;
      }
    }

    if (TransactionSynchronizationManager.hasResource(getEntityManagerFactory())) {
      // Do not modify the EntityManager: just mark the request accordingly.
      Integer count = (Integer) request.getAttribute(participateAttributeName, WebRequest.SCOPE_REQUEST);
      int newCount = (count != null ? count + 1 : 1);
      request.setAttribute(getParticipateAttributeName(), newCount, WebRequest.SCOPE_REQUEST);
    } else {
      logger.debug("Opening JPA EntityManager in OpenEntityManagerInViewInterceptor");
      try {
        EntityManager em = createEntityManager();
        EntityManagerHolder emHolder = new EntityManagerHolder(em);
        TransactionSynchronizationManager.bindResource(getEntityManagerFactory(), emHolder);

        AsyncRequestInterceptor interceptor = new AsyncRequestInterceptor(getEntityManagerFactory(), emHolder);
        asyncManager.registerCallableInterceptor(participateAttributeName, interceptor);
        asyncManager.registerDeferredResultInterceptor(participateAttributeName, interceptor);
      } catch (PersistenceException ex) {
        throw new DataAccessResourceFailureException("Could not create JPA EntityManager", ex);
      }
    }
  }
    private boolean applyCallableInterceptor (WebAsyncManager asyncManager, String key) {
      if (asyncManager.getCallableInterceptor(key) == null) {
        return false;
      }
      ((AsyncRequestInterceptor) asyncManager.getCallableInterceptor(key)).bindSession();
      return true;
    }
}
