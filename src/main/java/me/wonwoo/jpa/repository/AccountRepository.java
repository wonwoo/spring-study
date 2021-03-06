package me.wonwoo.jpa.repository;

import me.wonwoo.jpa.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wonwoo on 2016. 5. 16..
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
