package me.wonwoo.mybatis.dao;

import me.wonwoo.mybatis.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by wonwoo on 2016. 8. 6..
 */
@Repository
public class AccountDao {

  @Autowired
  private SqlSession sqlSession;

  public Account findByname(String name) {
    return this.sqlSession.selectOne("me.wonwoo.mybatis.mapper.AccountMapper.findByname", name);
  }
}
