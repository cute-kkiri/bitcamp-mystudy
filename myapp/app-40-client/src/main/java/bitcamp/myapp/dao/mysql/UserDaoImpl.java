package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

  private Connection con;

  public UserDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public boolean insert(User user) throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement()) {

      // insert 문 전달
      stmt.executeUpdate(String.format(
          "insert into myapp_users(name, email, pwd, tel)"
              + " values ('%s', '%s', sha1('%s'), '%s')",
          user.getName(),
          user.getEmail(),
          user.getPassword(),
          user.getTel()));

      return true;
    }
  }

  @Override
  public List<User> list() throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement();

        // select 문 실행을 요청한다.
        ResultSet rs = stmt.executeQuery("select * from myapp_users order by user_id asc")) {

      ArrayList<User> list = new ArrayList<>();

      while (rs.next()) { // select 실행 결과에서 1 개의 레코드를 가져온다.
        User user = new User();
        user.setNo(rs.getInt("user_id")); // 서버에서 가져온 레코드에서 user_id 컬럼 값을 꺼내 User 객체에 담는다.
        user.setName(rs.getString("name")); // 서버에서 가져온 레코드에서 name 컬럼 값을 꺼내 User 객체에 담는다.
        user.setEmail(rs.getString("email")); // 서버에서 가져온 레코드에서 email 컬럼 값을 꺼내 User 객체에 담는다.

        list.add(user);
      }

      return list;
    }
  }

  @Override
  public User findBy(int no) throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement();

        // select 문 실행을 요청한다.
        ResultSet rs = stmt.executeQuery("select * from myapp_users where user_id=" + no)) {

      if (rs.next()) { // select 실행 결과에서 1 개의 레코드를 가져온다.
        User user = new User();
        user.setNo(rs.getInt("user_id")); // 서버에서 가져온 레코드에서 user_id 컬럼 값을 꺼내 User 객체에 담는다.
        user.setName(rs.getString("name")); // 서버에서 가져온 레코드에서 name 컬럼 값을 꺼내 User 객체에 담는다.
        user.setEmail(rs.getString("email")); // 서버에서 가져온 레코드에서 email 컬럼 값을 꺼내 User 객체에 담는다.
        user.setTel(rs.getString("tel")); // 서버에서 가져온 레코드에서 tel 컬럼 값을 꺼내 User 객체에 담는다.

        return user;
      }

      return null;
    }
  }

  @Override
  public boolean update(User user) throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement()) {

      // update 문 전달
      int count = stmt.executeUpdate(String.format(
          "update myapp_users set"
              + " name='%s',"
              + " email='%s',"
              + " pwd=sha1('%s'),"
              + " tel='%s'"
              + " where user_id=%d",
          user.getName(),
          user.getEmail(),
          user.getPassword(),
          user.getTel(),
          user.getNo()));

      return count > 0;
    }
  }

  @Override
  public boolean delete(int no) throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement()) {

      // delete 문 전달
      int count = stmt.executeUpdate(String.format("delete from myapp_users where user_id=%d", no));

      return count > 0;
    }
  }
}
