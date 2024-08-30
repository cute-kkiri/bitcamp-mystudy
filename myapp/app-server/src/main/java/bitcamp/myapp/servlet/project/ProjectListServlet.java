package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/project/list")
public class ProjectListServlet extends GenericServlet {

    private ProjectDao projectDao;

    @Override
    public void init() throws ServletException {
        projectDao = (ProjectDao) this.getServletContext().getAttribute("projectDao");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            List<Project> list = projectDao.list();

            res.setContentType("text/html;charset=UTF-8");

            req.setAttribute("list", list);
            req.getRequestDispatcher("/project/list.jsp").include(req, res);

        } catch (Exception e) {
            req.setAttribute("exception", e);
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }
}
