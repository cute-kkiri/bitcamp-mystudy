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
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {


  MenuGroup mainMenu = new MenuGroup("메인");

  Map<Integer, User> userMap = new HashMap<>();
  List<Integer> userNoList = new ArrayList<>();

  Map<Integer, Board> boardMap = new HashMap<>();
  List<Integer> boardNoList = new ArrayList<>();

  Map<Integer, Project> projectMap = new HashMap<>();
  List<Integer> projectNoList = new ArrayList<>();

  public App() {

    loadData();

    MenuGroup userMenu = new MenuGroup("회원");
    userMenu.add(new MenuItem("등록", new UserAddCommand(userMap, userNoList)));
    userMenu.add(new MenuItem("목록", new UserListCommand(userMap, userNoList)));
    userMenu.add(new MenuItem("조회", new UserViewCommand(userMap)));
    userMenu.add(new MenuItem("변경", new UserUpdateCommand(userMap)));
    userMenu.add(new MenuItem("삭제", new UserDeleteCommand(userMap, userNoList)));
    mainMenu.add(userMenu);

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    ProjectMemberHandler memberHandler = new ProjectMemberHandler(userMap);
    projectMenu.add(
        new MenuItem("등록", new ProjectAddCommand(projectMap, projectNoList, memberHandler)));
    projectMenu.add(new MenuItem("목록", new ProjectListCommand(projectMap, projectNoList)));
    projectMenu.add(new MenuItem("조회", new ProjectViewCommand(projectMap)));
    projectMenu.add(new MenuItem("변경", new ProjectUpdateCommand(projectMap, memberHandler)));
    projectMenu.add(new MenuItem("삭제", new ProjectDeleteCommand(projectMap, projectNoList)));
    mainMenu.add(projectMenu);

    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new MenuItem("등록", new BoardAddCommand(boardMap, boardNoList)));
    boardMenu.add(new MenuItem("목록", new BoardListCommand(boardMap, boardNoList)));
    boardMenu.add(new MenuItem("조회", new BoardViewCommand(boardMap)));
    boardMenu.add(new MenuItem("변경", new BoardUpdateCommand(boardMap)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteCommand(boardMap, boardNoList)));
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
      mainMenu.execute();

    } catch (Exception ex) {
      System.out.println("실행 오류!");
      ex.printStackTrace();

    } finally {
      saveData();
    }

    System.out.println("종료합니다.");

    Prompt.close();
  }

  private void loadData() {
    try {
      XSSFWorkbook workbook = new XSSFWorkbook("data.xlsx");

      loadUsers(workbook);
      loadBoards(workbook);
      loadProjects(workbook);

      System.out.println("데이터를 로딩 했습니다.");

    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
      e.printStackTrace();
    }
  }

  private void loadUsers(XSSFWorkbook workbook) {
    XSSFSheet sheet = workbook.getSheet("users");

    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);
      try {
        User user = new User();
        user.setNo(Integer.parseInt(row.getCell(0).getStringCellValue()));
        user.setName(row.getCell(1).getStringCellValue());
        user.setEmail(row.getCell(2).getStringCellValue());
        user.setPassword(row.getCell(3).getStringCellValue());
        user.setTel(row.getCell(4).getStringCellValue());

        userMap.put(user.getNo(), user);
        userNoList.add(user.getNo());

      } catch (Exception e) {
        System.out.printf("%s 번 회원의 데이터 형식이 맞지 않습니다.\n", row.getCell(0).getStringCellValue());
      }
    }

    User.initSeqNo(userNoList.getLast());
  }

  private void loadBoards(XSSFWorkbook workbook) {
    XSSFSheet sheet = workbook.getSheet("boards");

    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);

      try {
        Board board = new Board();
        board.setNo(Integer.parseInt(row.getCell(0).getStringCellValue()));
        board.setTitle(row.getCell(1).getStringCellValue());
        board.setContent(row.getCell(2).getStringCellValue());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        board.setCreatedDate(formatter.parse(row.getCell(3).getStringCellValue()));

        board.setViewCount(Integer.parseInt(row.getCell(4).getStringCellValue()));

        boardMap.put(board.getNo(), board);
        boardNoList.add(board.getNo());

      } catch (Exception e) {
        System.out.printf("%s 번 게시글의 데이터 형식이 맞지 않습니다.\n", row.getCell(0).getStringCellValue());
      }
    }

    Board.initSeqNo(boardNoList.getLast());
  }

  private void loadProjects(XSSFWorkbook workbook) {
    XSSFSheet sheet = workbook.getSheet("projects");

    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);

      try {
        Project project = new Project();
        project.setNo(Integer.parseInt(row.getCell(0).getStringCellValue()));
        project.setTitle(row.getCell(1).getStringCellValue());
        project.setDescription(row.getCell(2).getStringCellValue());
        project.setStartDate(row.getCell(3).getStringCellValue());
        project.setEndDate(row.getCell(4).getStringCellValue());

        String[] members = row.getCell(5).getStringCellValue().split(",");
        for (String memberNo : members) {
          User member = userMap.get(Integer.valueOf(memberNo));
          if (member != null) {
            project.getMembers().add(member);
          }
        }
        projectMap.put(project.getNo(), project);
        projectNoList.add(project.getNo());

      } catch (Exception e) {
        System.out.printf("%s 번 프로젝트의 데이터 형식이 맞지 않습니다.\n", row.getCell(0).getStringCellValue());
      }
    }

    Project.initSeqNo(projectNoList.getLast());
  }

  private void saveData() {
    try {
      XSSFWorkbook workbook = new XSSFWorkbook();

      saveUsers(workbook);
      saveBoards(workbook);
      saveProjects(workbook);

      try (FileOutputStream out = new FileOutputStream("data.xlsx")) {
        workbook.write(out);
      }
      System.out.println("데이터를 저장 했습니다.");

    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }

  private void saveUsers(XSSFWorkbook workbook) {
    XSSFSheet sheet = workbook.createSheet("users");

    // 셀 이름 출력
    String[] cellHeaders = {"no", "name", "email", "password", "tel"};
    Row headerRow = sheet.createRow(0);
    for (int i = 0; i < cellHeaders.length; i++) {
      headerRow.createCell(i).setCellValue(cellHeaders[i]);
    }

    // 데이터 저장
    int rowNo = 1;
    for (Integer userNo : userNoList) {
      User user = userMap.get(userNo);
      Row dataRow = sheet.createRow(rowNo++);
      dataRow.createCell(0).setCellValue(String.valueOf(user.getNo()));
      dataRow.createCell(1).setCellValue(user.getName());
      dataRow.createCell(2).setCellValue(user.getEmail());
      dataRow.createCell(3).setCellValue(user.getPassword());
      dataRow.createCell(4).setCellValue(user.getTel());
    }
  }

  private void saveBoards(XSSFWorkbook workbook) {
    XSSFSheet sheet = workbook.createSheet("boards");

    // 셀 이름 출력
    String[] cellHeaders = {"no", "title", "content", "created_date", "view_count"};
    Row headerRow = sheet.createRow(0);
    for (int i = 0; i < cellHeaders.length; i++) {
      headerRow.createCell(i).setCellValue(cellHeaders[i]);
    }

    // 데이터 저장
    int rowNo = 1;
    for (Integer boardNo : boardNoList) {
      Board board = boardMap.get(boardNo);
      Row dataRow = sheet.createRow(rowNo++);
      dataRow.createCell(0).setCellValue(String.valueOf(board.getNo()));
      dataRow.createCell(1).setCellValue(board.getTitle());
      dataRow.createCell(2).setCellValue(board.getContent());

      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      dataRow.createCell(3).setCellValue(formatter.format(board.getCreatedDate()));

      dataRow.createCell(4).setCellValue(String.valueOf(board.getViewCount()));
    }
  }

  private void saveProjects(XSSFWorkbook workbook) {
    XSSFSheet sheet = workbook.createSheet("projects");

    // 셀 이름 출력
    String[] cellHeaders = {"no", "title", "description", "start_date", "end_date", "members"};
    Row headerRow = sheet.createRow(0);
    for (int i = 0; i < cellHeaders.length; i++) {
      headerRow.createCell(i).setCellValue(cellHeaders[i]);
    }

    // 데이터 저장
    int rowNo = 1;
    for (Integer projectNo : projectNoList) {
      Project project = projectMap.get(projectNo);
      Row dataRow = sheet.createRow(rowNo++);
      dataRow.createCell(0).setCellValue(String.valueOf(project.getNo()));
      dataRow.createCell(1).setCellValue(project.getTitle());
      dataRow.createCell(2).setCellValue(project.getDescription());
      dataRow.createCell(3).setCellValue(project.getStartDate());
      dataRow.createCell(4).setCellValue(project.getEndDate());

      StringBuilder strBuilder = new StringBuilder();
      for (User member : project.getMembers()) {
        if (strBuilder.length() > 0) {
          strBuilder.append(",");
        }
        strBuilder.append(member.getNo());
      }
      dataRow.createCell(5).setCellValue(strBuilder.toString());
    }
  }

}
