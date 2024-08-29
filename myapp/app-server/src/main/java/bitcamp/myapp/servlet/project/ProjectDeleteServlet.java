package bitcamp.myapp.servlet.project;

import bitcamp.myapp.dao.ProjectDao;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/project/delete")
public class ProjectDeleteServlet extends GenericServlet {

    private ProjectDao projectDao;
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void init() throws ServletException {
        this.projectDao = (ProjectDao) this.getServletContext().getAttribute("projectDao");
        this.sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();

        req.getRequestDispatcher("/header").include(req, res);

        try {
            out.println("<h1>프로젝트 삭제 결과</h1>");

            int projectNo = Integer.parseInt(req.getParameter("no"));

            projectDao.deleteMembers(projectNo);
            if (projectDao.delete(projectNo)) {
                sqlSessionFactory.openSession(false).commit();
                out.println("<p>삭제 했습니다.</p>");
            } else {
                out.println("<p>없는 프로젝트입니다.</p>");
            }

        } catch (Exception e) {
            sqlSessionFactory.openSession(false).rollback();
            out.println("<p>삭제 중 오류 발생!</p>");
        }

        out.println("</body>");
        out.println("</html>");

        ((HttpServletResponse) res).setHeader("Refresh", "1;url=/project/list");
    }
}
