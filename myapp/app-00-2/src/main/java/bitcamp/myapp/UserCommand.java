package bitcamp.myapp;

public class UserCommand {
    static final int MAX_SIZE = 100;
    static User[] users = new User[MAX_SIZE]; // 사용자 정의 데이터
    static int userLength = 0;

    static void executeUserCommand(String command) {
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
    static void addUser() {
        User user = new User(); // 메서드가 끝나면 사라짐.
        user.name = Prompt.input("이름?");
        user.email = Prompt.input("이메일?");
        user.password = Prompt.input("암호?");
        user.tel = Prompt.input("연락처?");
        users[userLength++] = user; // users배열에 user정보를 담음. 저장하고 userLength + 1한다.
    }

    // 목록
    static void listUser() {
        System.out.println("번호 이름 이메일");
        for (int i = 0; i < userLength; i++) {
            User user = users[i]; // 헷갈리니까 이렇게 하는 것을 추천.
            System.out.printf("%d %s %s\n", (i + 1), user.name, user.email);
        }
    }

    // 조회
    static void viewUser() {
        int userNo = Integer.parseInt(Prompt.input("회원번호?")); // prompt가 있는 클래스를 알려주기.(App 클래스에 있다.)
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return; // 메서드를 나가버리기.
        }
        User user = users[userNo - 1];
        System.out.printf("이름: %s\n", user.name);
        System.out.printf("이메일: %s\n", user.email);
        System.out.printf("연락처: %s\n", user.tel);
    }

    // 변경
    static void updateUser() {
        int userNo = Integer.parseInt(Prompt.input("회원번호?"));
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return; // 메서드를 나가버리기.
        }
        User user = users[userNo - 1];
        user.name = Prompt.input(String.format("이름(%s)?", user.name));
        user.email = Prompt.input(String.format("이메일(%s)?", user.email));
        user.password = Prompt.input("암호?");
        user.tel = Prompt.input(String.format("연락처(%s)?", user.tel));
        System.out.println("변경했습니다.");
    }

    // 삭제
    static void deleteUser() {
        int userNo = Integer.parseInt(Prompt.input("회원번호?"));
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return; // 메서드를 나가버리기.
        }
        // 다음 값을 앞으로 당긴다.
        for (int i = userNo; i < userLength; i++) { // 중간 값들이 당겨짐.
            users[i - 1] = users[i]; // 현재 userNo 이후에 있는걸 앞으로 당김.
        }
        userLength--; // 마지막 항목을 제거할 때는 for문을 안돌고 --하고 그냥 null 처리됨.
        // 레퍼런스 카운트 제거 (가비지 처리를 제대로 하기 위함.)
        users[userLength] = null;
        System.out.println("삭제 했습니다.");
    }
}
