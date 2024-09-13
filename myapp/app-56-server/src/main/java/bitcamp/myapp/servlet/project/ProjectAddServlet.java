package bitcamp.myapp.servlet.project;

import bitcamp.myapp.service.ProjectService;
import bitcamp.myapp.vo.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project/add")
public class ProjectAddServlet extends HttpServlet {

  private ProjectService projectService;

  @Override
  public void init() throws ServletException {
    this.projectService = (ProjectService) this.getServletContext().getAttribute("projectService");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      Project project = (Project) req.getSession().getAttribute("project");
      projectService.add(project);
      req.getSession().removeAttribute("project");
      res.sendRedirect("/project/list");

    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, res);
    }
  }
}
