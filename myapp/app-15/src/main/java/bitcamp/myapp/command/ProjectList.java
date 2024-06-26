package bitcamp.myapp.command;

import bitcamp.myapp.vo.Project;

public class ProjectList extends ArrayList {
    public Project findByNo(int userNo) {
        for (int i = 0; i < size(); i++) {
            Project project = (Project) get(i);
            if (project.getNo() == userNo) {
                return project;
            }
        }
        return null;
    }
}
