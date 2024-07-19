package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.command.HelpCommand;
import bitcamp.myapp.command.HistoryCommand;
import bitcamp.myapp.command.board.BoardAddCommand;
import bitcamp.myapp.command.board.BoardDeleteCommand;
import bitcamp.myapp.command.board.BoardListCommand;
import bitcamp.myapp.command.board.BoardUpdateCommand;
import bitcamp.myapp.command.board.BoardViewCommand;
import bitcamp.myapp.command.project.ProjectAddCommand;
import bitcamp.myapp.command.project.ProjectDeleteCommand;
import bitcamp.myapp.command.project.ProjectListCommand;
import bitcamp.myapp.command.project.ProjectMemberHandler;
import bitcamp.myapp.command.project.ProjectUpdateCommand;
import bitcamp.myapp.command.project.ProjectViewCommand;
import bitcamp.myapp.command.user.UserAddCommand;
import bitcamp.myapp.command.user.UserDeleteCommand;
import bitcamp.myapp.command.user.UserListCommand;
import bitcamp.myapp.command.user.UserUpdateCommand;
import bitcamp.myapp.command.user.UserViewCommand;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class App {


  MenuGroup mainMenu = new MenuGroup("메인");

  List<User> userList = new ArrayList<>();
  List<Project> projectList = new LinkedList<>();
  List<Board> boardList = new LinkedList<>();

  public App() {

    MenuGroup userMenu = new MenuGroup("회원");
    userMenu.add(new MenuItem("등록", new UserAddCommand(userList)));
    userMenu.add(new MenuItem("목록", new UserListCommand(userList)));
    userMenu.add(new MenuItem("조회", new UserViewCommand(userList)));
    userMenu.add(new MenuItem("변경", new UserUpdateCommand(userList)));
    userMenu.add(new MenuItem("삭제", new UserDeleteCommand(userList)));
    mainMenu.add(userMenu);

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    ProjectMemberHandler memberHandler = new ProjectMemberHandler(userList);
    projectMenu.add(new MenuItem("등록", new ProjectAddCommand(projectList, memberHandler)));
    projectMenu.add(new MenuItem("목록", new ProjectListCommand(projectList)));
    projectMenu.add(new MenuItem("조회", new ProjectViewCommand(projectList)));
    projectMenu.add(new MenuItem("변경", new ProjectUpdateCommand(projectList, memberHandler)));
    projectMenu.add(new MenuItem("삭제", new ProjectDeleteCommand(projectList)));
    mainMenu.add(projectMenu);

    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new MenuItem("등록", new BoardAddCommand(boardList)));
    boardMenu.add(new MenuItem("목록", new BoardListCommand(boardList)));
    boardMenu.add(new MenuItem("조회", new BoardViewCommand(boardList)));
    boardMenu.add(new MenuItem("변경", new BoardUpdateCommand(boardList)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteCommand(boardList)));
    mainMenu.add(boardMenu);

    mainMenu.add(new MenuItem("도움말", new HelpCommand()));
    mainMenu.add(new MenuItem("명령내역", new HistoryCommand()));

    mainMenu.setExitMenuTitle("종료");
  }


  public static void main(String[] args) {
    new App().execute();
  }

  void execute() {
    String appTitle = "[프로젝트 관리 시스템]";
    String line = "----------------------------------";

    try {
      loadData();
      mainMenu.execute();
    } catch (Exception ex) {
      System.out.println("실행 오류!");
    } finally {
      saveData();
    }

    System.out.println("종료합니다.");

    Prompt.close();
  }

  private void loadData() {
    loadUsers();
    loadProjects();
    loadBoards();
    System.out.println("데이터를 로딩 했습니다.");
  }

  private void loadUsers() {
    try (FileInputStream in0 = new FileInputStream("user.data");
        DataInputStream in = new DataInputStream(in0)) {

      int userLength = in.readInt();

      int maxUserNo = 0;
      for (int i = 0; i < userLength; i++) {
        User user = new User();
        user.setNo(in.readInt());
        user.setName(in.readUTF());
        user.setEmail(in.readUTF());
        user.setPassword(in.readUTF());
        user.setTel(in.readUTF());

        userList.add(user);

        if (user.getNo() > maxUserNo) {
          maxUserNo = user.getNo();
        }
      }

      User.initSeqNo(maxUserNo);

    } catch (IOException e) {
      System.out.println("회원 정보 로딩 중 오류 발생!");
    }
  }

  private void loadProjects() {
    try (FileInputStream in0 = new FileInputStream("project.data");
        DataInputStream in = new DataInputStream(in0)) {

      int projectLength = in.readInt();

      int maxProjectNo = 0;
      for (int i = 0; i < projectLength; i++) {
        Project project = new Project();
        project.setNo(in.readInt());
        project.setTitle(in.readUTF());
        project.setDescription(in.readUTF());
        project.setStartDate(in.readUTF());
        project.setEndDate(in.readUTF());

        int memberLength = in.readInt();
        for (int j = 0; j < memberLength; j++) {
          User user = new User();
          user.setNo(in.readInt());
          user.setName(in.readUTF());
          user.setEmail(in.readUTF());
          user.setPassword(in.readUTF());
          user.setTel(in.readUTF());

          project.getMembers().add(user);
        }

        projectList.add(project);

        if (project.getNo() > maxProjectNo) {
          maxProjectNo = project.getNo();
        }
      }

      Project.initSeqNo(maxProjectNo);

    } catch (IOException e) {
      System.out.println("프로젝트 정보 로딩 중 오류 발생!");
    }
  }

  private void loadBoards() {
    try (FileInputStream in0 = new FileInputStream("board.data");
        DataInputStream in = new DataInputStream(in0)) {

      int userLength = in.readInt();

      int maxBoardNo = 0;
      for (int i = 0; i < userLength; i++) {
        Board board = new Board();
        board.setNo(in.readInt());
        board.setTitle(in.readUTF());
        board.setContent(in.readUTF());
        board.setCreatedDate(new Date(in.readLong()));
        board.setViewCount(in.readInt());

        boardList.add(board);

        if (board.getNo() > maxBoardNo) {
          maxBoardNo = board.getNo();
        }
      }

      Board.initSeqNo(maxBoardNo);

    } catch (IOException e) {
      System.out.println("게시글 정보 로딩 중 오류 발생!");
    }
  }

  private void saveData() {
    saveUsers();
    saveProjects();
    saveBoards();
    System.out.println("데이터를 저장 했습니다.");
  }

  private void saveUsers() {
    try (FileOutputStream out0 = new FileOutputStream("user.data");
        DataOutputStream out = new DataOutputStream(out0)) {

      out.writeInt(userList.size());

      for (User user : userList) {
        out.writeInt(user.getNo());
        out.writeUTF(user.getName());
        out.writeUTF(user.getEmail());
        out.writeUTF(user.getPassword());
        out.writeUTF(user.getTel());
      }
    } catch (IOException e) {
      System.out.println("회원 정보 저장 중 오류 발생!");
    }
  }

  private void saveProjects() {
    try (FileOutputStream out0 = new FileOutputStream("project.data");
        DataOutputStream out = new DataOutputStream(out0)) {

      out.writeInt(projectList.size());

      for (Project project : projectList) {
        out.writeInt(project.getNo());
        out.writeUTF(project.getTitle());
        out.writeUTF(project.getDescription());
        out.writeUTF(project.getStartDate());
        out.writeUTF(project.getEndDate());
        out.writeInt(project.getMembers().size());
        for (User member : project.getMembers()) {
          out.writeInt(member.getNo());
          out.writeUTF(member.getName());
          out.writeUTF(member.getEmail());
          out.writeUTF(member.getPassword());
          out.writeUTF(member.getTel());
        }
      }
    } catch (IOException e) {
      System.out.println("프로젝트 정보 저장 중 오류 발생!");
    }
  }

  private void saveBoards() {
    try (FileOutputStream out0 = new FileOutputStream("board.data");
        DataOutputStream out = new DataOutputStream(out0)) {

      out.writeInt(boardList.size());

      for (Board board : boardList) {
        out.writeInt(board.getNo());
        out.writeUTF(board.getTitle());
        out.writeUTF(board.getContent());
        out.writeLong(board.getCreatedDate().getTime());
        out.writeInt(board.getViewCount());
      }
    } catch (IOException e) {
      System.out.println("게시글 정보 저장 중 오류 발생!");
    }
  }
}
