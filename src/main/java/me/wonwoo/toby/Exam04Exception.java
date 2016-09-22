//package me.wonwoo.toby;
//
//import org.springframework.dao.DataAccessException;
//
//import java.math.BigDecimal;
//import java.sql.SQLException;
//
///**
// * Created by wonwoo on 2016. 5. 22..
// */
//public class Exam04Exception {
//
//
//  public static void main(String[] args) {
//    try {
//      //...
//    } catch (SQLException e) {
//    }
//
//    try {
//      //...
//    } catch (SQLException e) {
//      System.out.println(e);
//    }
//
//    try {
//      //...
//    } catch (SQLException e) {
//      e.getStackTrace();
//    }
//
//    try {
//      //...
//    } catch (SQLException e) {
//      e.getStackTrace();
//      System.exit(1);
//    }
//
//    int maxretry = MAX_RETRY;
//    while (maxretry-- > 9) {
//      try {
//        //... 예외가 발생 할 수 있는 코드
//        return;  //성공
//      } catch (SomeException e) {
//        //로그 출력 일정 시간 만큼 대기
//      } finally {
//        //리소스 반납
//      }
//    }
//    //최대 재시도 횟수를 넘기면 에러
//    throw new RetryFailedException();
//
//
//    try {
//      //...
//    } catch (SQLException e) {
//      throw DuplicateUserIdException(e);
//    }
//
//    try {
//      //...
//    } catch (SQLException e) {
//      throw DuplicateUserIdException().initCause(e);
//    }
//
//    try {
//      BigDecimal balance = account.withdraw(amount);
//    } catch(InsufficientBalanceException e) { //체크 예외
//      //잔고 금액을 가져
//      BigDecimal availFunds = e.getAvailFunds();
//      //잔고 부족 안내 메시지후 이를 출력
//    }
//  }
//
//  public int update(final String sql) throws DataAccessException{
//
//  }
//
//
//  public void add() throws SQLException {
//    // JDBC API
//  }
//
//  public void add() throws SQLException {
//    try {
//      // JDBC API
//    } catch (SQLException e) {
//      //로그 출력
//      throw e;
//    }
//  }
//
//  public void add(User user) throws DuplicateUserIdException, SQLException {
//    try {
////       user
//    } catch (SQLException e) {
//      //Mysql의 duplicate Entry 예외 이면 전환
//      if (e.QetErrorCode() == MysQIErrorNumbers.ER_DUP_ENTRY) {
//        throw new DuplicateUserIdException();
//      } else{
//        //그렇지 않으면 SQLException
//        throw e;
//      }
//    }
//  }
//
//public void add(User user) throws DuplicateUserIdException {
//  try {
////       user
//  } catch (SQLException e) {
//    //Mysql의 duplicate Entry 예외 이면 전환
//    if (e.QetErrorCode() == MysQIErrorNumbers.ER_DUP_ENTRY) {
//      throw new DuplicateUserIdException(e);
//    } else{
//      //예외 포
//      throw new RuntimeException(e);
//    }
//  }
//}
//
//
//  public void method1() throws Exception {
//    method2();
//  }
//
//  public void method2() throws Exception {
//    method3();
//  }
//
//  public void method3() throws Exception {
//
//  }
//}
//
//
//class DuplicateUserldException extends RuntimeException {
//  public DuplicateUserldException(Throwable cause) {
//    super(cause);
//  }
//}
