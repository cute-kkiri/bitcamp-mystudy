package bitcamp.myapp.command;

import bitcamp.myapp.util.Prompt;
import bitcamp.myapp.vo.Board;

public class BoardCommand {
    private static final int MAX_SIZE = 100;
    private static Board[] boards = new Board[MAX_SIZE]; // 사용자 정의 데이터
    private static int boardLength = 0;

    public static void executeBoardCommand(String command) {
        System.out.printf("[%s]\n", command);

        switch (command) {
            case "등록":
                addUser();
                break;
            case "조회":
                viewUser();
                break;
            case "목록":
                listUser();
                break;
            case "변경":
                updateUser();
                break;
            case "삭제":
                deleteUser();
                break;
        }
    }

    // 등록
    private static void addUser() {
        Board board = new Board();
        board.setTitle(Prompt.input("제목?"));
        board.setContent(Prompt.input("내용?"));
        board.setDate(board.getDate());
        boards[boardLength++] = board;
        System.out.println("등록했습니다.");
    }

    // 목록
    private static void listUser() {
        System.out.println("번호 제목 작성일 조회수");
        for (int i = 0; i < boardLength; i++) {
            Board board = boards[i];
            System.out.printf("%d %s %s %d\n", (i + 1), board.getTitle(), board.getDate(), i);
        }
    }

    // 조회
    private static void viewUser() {
        System.out.println("조회");
        int boardNo = Prompt.inputInt("게시글 번호?");
        if (boardNo < 1 || boardNo > boardLength) {
            System.out.println("없는 게시글입니다.");
            return;
        }
        Board board = boards[boardNo - 1];
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("작성일: %s\n", board.getDate());
        System.out.printf("조회수: %d\n", 1);
    }

    // 변경
    private static void updateUser() {
        int boardNo = Prompt.inputInt("게시글 번호?");
        if (boardNo < 1 || boardNo > boardLength) {
            System.out.println("없는 게시글입니다.");
            return;
        }
        Board board = boards[boardNo - 1];
        board.setTitle(Prompt.input("제목(%s)?", board.getTitle()));
        board.setContent(Prompt.input("내용(%s)?", board.getContent()));
        System.out.println("변경하였습니다.");
    }

    // 삭제
    private static void deleteUser() {
        int boardNo = Prompt.inputInt("프로젝트 번호?");
        if (boardNo < 1 || boardNo > boardLength) {
            System.out.println("없는 프로젝트입니다.");
            return;
        }
        for (int i = boardNo; i < boardLength; i++) {
            boards[i - 1] = boards[i];
        }
        boards[--boardLength] = null;
        System.out.println("삭제 했습니다.");
    }
}
