package me.wonwoo.mybatis.mapper;

import me.wonwoo.mybatis.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wonwoo on 2016. 8. 6..
 */
@Mapper
public interface AccountMapper {
  Account findByemail(String email);

  @Select("SELECT * FROM ACCOUNT WHERE id = #{id}")
  Account findById(@Param("id") Long id);
}
