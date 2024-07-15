package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.command.*;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;

import java.util.*;

public class App {


    MenuGroup mainMenu = new MenuGroup("메인");

    UserCommand userCommand;
    BoardCommand boardCommand;
    ProjectCommand projectCommand;
    HelpCommand helpCommand;
    HistoryCommand historyCommand;

    Map<String, Command> commandMap = new HashMap<>();

    public App() {
        List<User> userList = new ArrayList<>();
        List<Project> projectList = new LinkedList<>();
        List<Board> boardList = new LinkedList<>();

        userCommand = new UserCommand(userList);
        boardCommand = new BoardCommand(boardList);
        projectCommand = new ProjectCommand(projectList, userList);
        helpCommand = new HelpCommand();
        historyCommand = new HistoryCommand();

        MenuGroup userMenu = new MenuGroup("회원");
        userMenu.add(new MenuItem("등록", userCommand));
        userMenu.add(new MenuItem("목록", userCommand));
        userMenu.add(new MenuItem("조회", userCommand));
        userMenu.add(new MenuItem("변경", userCommand));
        userMenu.add(new MenuItem("삭제", userCommand));
        mainMenu.add(userMenu);

        MenuGroup projectMenu = new MenuGroup("프로젝트");
        projectMenu.add(new MenuItem("등록", projectCommand));
        projectMenu.add(new MenuItem("목록", projectCommand));
        projectMenu.add(new MenuItem("조회", projectCommand));
        projectMenu.add(new MenuItem("변경", projectCommand));
        projectMenu.add(new MenuItem("삭제", projectCommand));
        mainMenu.add(projectMenu);

        MenuGroup boardMenu = new MenuGroup("게시판");
        boardMenu.add(new MenuItem("등록", boardCommand));
        boardMenu.add(new MenuItem("목록", boardCommand));
        boardMenu.add(new MenuItem("조회", boardCommand));
        boardMenu.add(new MenuItem("변경", boardCommand));
        boardMenu.add(new MenuItem("삭제", boardCommand));
        mainMenu.add(boardMenu);

        mainMenu.add(new MenuItem("도움말", helpCommand));
        mainMenu.add(new MenuItem("명령내역", historyCommand));

        mainMenu.setExitMenuTitle("종료");
    }


    public static void main(String[] args) {
        new App().execute();
    }

    void execute() {
        String appTitle = "[프로젝트 관리 시스템]";
        String line = "----------------------------------";

        try {
            mainMenu.execute();
        } catch (Exception ex) {
            System.out.println("실행 오류!");
        }

        System.out.println("종료합니다.");

        Prompt.close();
    }
}
