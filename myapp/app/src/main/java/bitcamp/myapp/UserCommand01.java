package bitcamp.myapp;

public class UserCommand01 {
    static final int MAX_SIZE = 100;
    static String[] name = new String[MAX_SIZE];
    static String[] email = new String[MAX_SIZE];
    static String[] password = new String[MAX_SIZE];
    static String[] tel = new String[MAX_SIZE];
    static int memberLength = 0;

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
        name[memberLength] = Prompt.Input("이름?");
        email[memberLength] = Prompt.Input("이메일?");
        password[memberLength] = Prompt.Input("암호?");
        tel[memberLength] = Prompt.Input("연락처?");
        memberLength++;
    }

    // 목록
    static void listUser() {
        System.out.println("번호 이름 이메일");
        for (int i = 0; i < memberLength; i++) {
            System.out.printf("%d %s %s\n", (i + 1), name[i], email[i]);
        }
    }

    // 조회
    static void viewUser() {
        int userNo = Integer.parseInt(Prompt.Input("회원번호?")); // prompt가 있는 클래스를 알려주기.(App 클래스에 있다.)
        if (userNo < 1 || userNo > memberLength) {
            System.out.println("없는 회원입니다.");
            return; // 메서드를 나가버리기.
        }
        System.out.printf("이름: %s\n", name[userNo - 1]);
        System.out.printf("이메일: %s\n", email[userNo - 1]);
        System.out.printf("연락처: %s\n", tel[userNo - 1]);
    }

    // 변경
    static void updateUser() {
        int userNo = Integer.parseInt(Prompt.Input("회원번호?"));
        if (userNo < 1 || userNo > memberLength) {
            System.out.println("없는 회원입니다.");
            return; // 메서드를 나가버리기.
        }
        name[userNo - 1] = Prompt.Input(String.format("이름(%s)?", name[userNo - 1]));
        email[userNo - 1] = Prompt.Input(String.format("이메일(%s)?", email[userNo - 1]));
        password[userNo - 1] = Prompt.Input("암호?");
        tel[userNo - 1] = Prompt.Input(String.format("연락처(%s)?", tel[userNo - 1]));
        System.out.println("변경했습니다.");
    }

    // 삭제
    static void deleteUser() {
        int userNo = Integer.parseInt(Prompt.Input("회원번호?"));
        if (userNo < 1 || userNo > memberLength) {
            System.out.println("없는 회원입니다.");
            return; // 메서드를 나가버리기.
        }
        // 다음 값을 앞으로 당긴다.
        for (int i = userNo; i < memberLength; i++) { // 중간 값들이 당겨짐.
            name[i - 1] = name[i]; // 현재 userNo 이후에 있는걸 앞으로 당김.
            email[i - 1] = email[i];
            password[i - 1] = password[i];
            tel[i - 1] = tel[i];
        }
        memberLength--; // 마지막 항목을 제거할 때는 for문을 안돌고 --하고 그냥 null 처리됨.
        // 레퍼런스 카운트 제거 (가비지 처리를 제대로 하기 위함.)
        name[memberLength] = null;
        email[memberLength] = null;
        password[memberLength] = null;
        tel[memberLength] = null;
    }
}
