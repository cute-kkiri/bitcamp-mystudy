package bitcamp.myapp.servlet.project;

import bitcamp.myapp.service.ProjectService;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project/delete")
public class ProjectDeleteServlet extends HttpServlet {

  private ProjectService projectService;
  private SqlSessionFactory sqlSessionFactory;

  @Override
  public void init() throws ServletException {
    this.projectService = (ProjectService) this.getServletContext().getAttribute("projectService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      int projectNo = Integer.parseInt(req.getParameter("no"));

      if (projectService.delete(projectNo)) {
        res.sendRedirect("/project/list");
      } else {
        throw new Exception("없는 프로젝트입니다.");
      }

    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
  }
}
