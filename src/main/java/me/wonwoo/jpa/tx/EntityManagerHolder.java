package me.wonwoo.jpa.tx;

import org.springframework.transaction.SavepointManager;

import javax.persistence.EntityManager;

/**
 * study
 * Created by wonwoo on 2016. 5. 17..
 */
public class EntityManagerHolder extends org.springframework.orm.jpa.EntityManagerHolder {


  public EntityManagerHolder(EntityManager entityManager) {
    super(entityManager);
  }


  public EntityManager getEntityManager() {
    return super.getEntityManager();
  }

  protected void setTransactionActive(boolean transactionActive) {
    super.setTransactionActive(transactionActive);
  }

  protected boolean isTransactionActive() {
    return super.isTransactionActive();
  }

  protected void setSavepointManager(SavepointManager savepointManager) {
    super.setSavepointManager(savepointManager);
  }

  protected SavepointManager getSavepointManager() {
    return super.getSavepointManager();
  }

}
