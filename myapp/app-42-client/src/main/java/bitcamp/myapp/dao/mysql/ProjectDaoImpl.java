package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

  private Connection con;

  public ProjectDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public boolean insert(Project project) throws Exception {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate(String.format(
              "insert into myapp_projects(title,description,start_date,end_date)"
                  + " values ('%s','%s','%s','%s')",
              project.getTitle(),
              project.getDescription(),
              project.getStartDate(),
              project.getEndDate()),
          Statement.RETURN_GENERATED_KEYS // insert 실행 후 자동 생성된 PK 값을 가져오는 옵션
      );

      // PK 컬럼 값 가져올 때 사용할 ResultSet 객체를 준비
      ResultSet keyRS = stmt.getGeneratedKeys();

      // ResultSet 객체를 통해 서버에서 PK 값을 가져온다.
      // => Project를 한 개 insert 했기 때문에 생성된 PK 값도 한 개다.
      // => 따라서 가져올 PK 값도 한 개다.
      keyRS.next();

      // PK 컬럼이 한 개이기 때문에 1 번째 컬럼 값을 꺼낸다.
      // PK 컬럼을 가져올 때는 컬럼 이름으로 꺼내는 것이 아니라 순번으로 꺼낸다.
      // 컬럼 인덱스는 1번부터 시작한다.
      int projectNo = keyRS.getInt(1);

      // 호출할 쪽에서 project PK 값을 사용할 수 있도록 Project 객체에 담아 둔다.
      project.setNo(projectNo);

      return true;
    }
  }

  @Override
  public List<Project> list() throws Exception {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from myapp_projects order by project_id asc")) {
      ArrayList<Project> list = new ArrayList<>();
      while (rs.next()) {
        Project project = new Project();
        project.setNo(rs.getInt("project_id"));
        project.setTitle(rs.getString("title"));
        project.setStartDate(rs.getDate("start_date"));
        project.setEndDate(rs.getDate("end_date"));
        list.add(project);
      }
      return list;
    }
  }

  @Override
  public Project findBy(int no) throws Exception {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from myapp_projects where project_id=" + no)) {
      if (rs.next()) {
        Project project = new Project();
        project.setNo(rs.getInt("project_id"));
        project.setTitle(rs.getString("title"));
        project.setDescription(rs.getString("description"));
        project.setStartDate(rs.getDate("start_date"));
        project.setEndDate(rs.getDate("end_date"));
        return project;
      }
      return null;
    }
  }

  @Override
  public boolean update(Project project) throws Exception {
    try (Statement stmt = con.createStatement()) {
      int count = stmt.executeUpdate(String.format(
          "update myapp_projects set"
              + " title='%s',"
              + " description='%s',"
              + " start_date='%s',"
              + " end_date='%s'"
              + " where project_id=%d",
          project.getTitle(),
          project.getDescription(),
          project.getStartDate(),
          project.getEndDate(),
          project.getNo()));
      return count > 0;
    }
  }

  @Override
  public boolean delete(int no) throws Exception {
    try (Statement stmt = con.createStatement()) {
      int count = stmt.executeUpdate(
          String.format("delete from myapp_projects where project_id=%d", no));
      return count > 0;
    }
  }

  @Override
  public boolean insertMembers(int projectNo, List<User> members) throws Exception {
    try (Statement stmt = con.createStatement()) {

      for (User user : members) {
        stmt.executeUpdate(String.format(
            "insert into myapp_project_members(project_id, user_id)"
                + " values (%d, %d)",
            projectNo,
            user.getNo()));
      }
      return true;
    }
  }

  @Override
  public List<User> getMembers(int projectNo) throws Exception {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select "
                + " pm.user_id,"
                + " u.name"
                + " from myapp_project_members pm"
                + "  inner join myapp_users u on pm.user_id=u.user_id"
                + " where pm.project_id=" + projectNo)) {
      ArrayList<User> list = new ArrayList<>();
      while (rs.next()) {
        User user = new User();
        user.setNo(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        list.add(user);
      }
      return list;
    }
  }

  @Override
  public boolean deleteMembers(int projectNo) throws Exception {
    try (Statement stmt = con.createStatement()) {
      int count = stmt.executeUpdate(
          String.format("delete from myapp_project_members where project_id=%d", projectNo));
      return count > 0;
    }
  }
}
