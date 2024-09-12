package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project/add")
public class ProjectAddServlet extends HttpServlet {

  private ProjectDao projectDao;
  private SqlSessionFactory sqlSessionFactory;

  @Override
  public void init() throws ServletException {
    ServletContext ctx = this.getServletContext();
    this.projectDao = (ProjectDao) ctx.getAttribute("projectDao");
    this.sqlSessionFactory = (SqlSessionFactory) ctx.getAttribute("sqlSessionFactory");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      Project project = (Project) req.getSession().getAttribute("project");
      projectDao.insert(project);

      if (project.getMembers() != null && project.getMembers().size() > 0) {
        projectDao.insertMembers(project.getNo(), project.getMembers());
      }
      sqlSessionFactory.openSession(false).commit();
      res.sendRedirect("/project/list");

      // 세션에 임시 보관했던 Project 객체를 제거한다.
      req.getSession().removeAttribute("project");

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
  }
}
