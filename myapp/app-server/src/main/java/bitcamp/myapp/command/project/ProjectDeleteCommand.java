package bitcamp.myapp.command.project;

import bitcamp.command.Command;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import bitcamp.net.Prompt;
import org.apache.ibatis.session.SqlSession;

public class ProjectDeleteCommand implements Command {

    private ProjectDao projectDao;
    private SqlSession sqlSession;

    public ProjectDeleteCommand(ProjectDao projectDao, SqlSession sqlSession) {
        this.projectDao = projectDao;
        this.sqlSession = sqlSession;
    }

    @Override
    public void execute(String menuName, Prompt prompt) {
        try {
            prompt.printf("[%s]\n", menuName);
            int projectNo = prompt.inputInt("프로젝트 번호?");

            try {
                Project deletedProject = projectDao.findBy(projectNo);
                if (deletedProject == null) {
                    prompt.println("없는 프로젝트입니다.");
                    return;
                }

                projectDao.deleteMembers(projectNo);
                projectDao.delete(projectNo);
                sqlSession.commit();
                prompt.printf("%d번 프로젝트를 삭제 했습니다.\n", deletedProject.getNo());

            } catch (Exception e) {
                sqlSession.rollback();
                prompt.println("삭제 중 오류 발생!");
            }
        } catch (Exception e) {

        }
    }
}
