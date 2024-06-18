package bitcamp.myapp.command;

import bitcamp.myapp.util.Prompt;
import bitcamp.myapp.vo.User;

public class UserCommand {
    private static final int MAX_SIZE = 100;
    private static User[] users = new User[MAX_SIZE]; // 사용자 정의 데이터
    private static int userLength = 0;

    public static void executeUserCommand(String command) {
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
        User user = new User(); // 메서드가 끝나면 사라짐.
        user.setName(Prompt.input("이름?"));
        user.setEmail(Prompt.input("이메일?"));
        user.setPassword(Prompt.input("암호?"));
        user.setTel(Prompt.input("연락처?"));
        users[userLength++] = user; // users배열에 user정보를 담음. 저장하고 userLength + 1한다.
    }

    // 목록
    private static void listUser() {
        System.out.println("번호 이름 이메일");
        for (int i = 0; i < userLength; i++) {
            User user = users[i]; // 헷갈리니까 이렇게 하는 것을 추천.
            System.out.printf("%d %s %s\n", (i + 1), user.getName(), user.getEmail());
        }
    }

    // 조회
    private static void viewUser() {
        int userNo = Prompt.inputInt("회원번호?"); // prompt가 있는 클래스를 알려주기.(App 클래스에 있다.)
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return; // 메서드를 나가버리기.
        }
        User user = users[userNo - 1];
        System.out.printf("이름: %s\n", user.getName());
        System.out.printf("이메일: %s\n", user.getEmail());
        System.out.printf("연락처: %s\n", user.getTel());
    }

    // 변경
    private static void updateUser() {
        int userNo = Prompt.inputInt("회원번호?");
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return; // 메서드를 나가버리기.
        }
        User user = users[userNo - 1];
        user.setName(Prompt.input("이름(%s)?", user.getName()));
        user.setEmail(Prompt.input("이메일(%s)?", user.getEmail()));
        user.setPassword(Prompt.input("암호?"));
        user.setTel(Prompt.input("연락처(%s)?", user.getTel()));
        System.out.println("변경했습니다.");
    }

    // 삭제
    private static void deleteUser() {
        int userNo = Prompt.inputInt("회원번호?");
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return; // 메서드를 나가버리기.
        }
        // 다음 값을 앞으로 당긴다.
        for (int i = userNo; i < userLength; i++) { // 중간 값들이 당겨짐.
            users[i - 1] = users[i]; // 현재 userNo 이후에 있는걸 앞으로 당김.
        }
        // userLength--; // 마지막 항목을 제거할 때는 for문을 안돌고 --하고 그냥 null 처리됨.
        // 레퍼런스 카운트 제거 (가비지 처리를 제대로 하기 위함.)
        users[--userLength] = null;
        System.out.println("삭제 했습니다.");
    }

    // 외부에서 user 정보 조회
    public static User findByNo(int userNo) {
        if (userNo < 1 || userNo > userLength) {
            return null;
        }

        return users[userNo - 1];
    }

}
