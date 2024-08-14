package bitcamp.myapp.command.project;

import bitcamp.command.Command;
import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import bitcamp.util.Prompt;

public class ProjectDeleteCommand implements Command {

    private ProjectDao projectDao;

    public ProjectDeleteCommand(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public void execute(String menuName) {
        System.out.printf("[%s]\n", menuName);
        int projectNo = Prompt.inputInt("프로젝트 번호?");

        try {
            Project deletedProject = projectDao.findBy(projectNo);
            if (deletedProject == null) {
                System.out.println("없는 프로젝트입니다.");
                return;
            }

            // 자식 테이블의 데이터를 삭제해야 부모 테이블의 데이터를 삭제할 수 있다.
            projectDao.deleteMembers(projectNo);
            projectDao.delete(projectNo);
            System.out.printf("%d번 프로젝트를 삭제 했습니다.\n", deletedProject.getNo());

        } catch (Exception e) {
            System.out.println("삭제 중 오류 발생!");
        }
    }
}
