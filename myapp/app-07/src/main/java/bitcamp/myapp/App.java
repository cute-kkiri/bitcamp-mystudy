/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.myapp;

import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyboardScanner = new java.util.Scanner(keyboard);

        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";
        String appTitle = "[팀 프로젝트 관리 시스템]";
        String line = "----------------------------------------";

        // 배열 저장
        String[] menus = new String[] {
                "회원",
                "팀",
                "프로젝트",
                "게시판",
                "도움말",
                "종료"
        };

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);

        for (int i = 0; i < menus.length; i++) {
            if (menus[i] == "종료") {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), menus[i], resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), menus[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);

        String command;

        while(true) {
            // 예외가 발생했을 때 멈추지 않고 계속 실행하게 만드는 문법. try ~ catch
            try {
                System.out.print("> ");
                command = keyboardScanner.nextLine();

                if (command.equals("menu")) { // String Literals 영역 안에서 "menu"라는 string이 있는지 찾고 비교하기 때문에 equals()로 비교해 줘야한다.
                    // System.out.println("메뉴출력");

                    System.out.println(boldAnsi + line + resetAnsi);
                    System.out.println(boldAnsi + appTitle + resetAnsi);

                    for (int i = 0; i < menus.length; i++) {
                        if (menus[i].equals("종료")) {
                            System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), menus[i], resetAnsi);
                        } else {
                            System.out.printf("%d. %s\n", (i + 1), menus[i]);
                        }
                    }

                    System.out.println(boldAnsi + line + resetAnsi);

                } else {
                    int menuNo = Integer.parseInt(command); // 문자열을 int 값으로 바꿈.

                    if (menuNo >= 1 && menuNo <= menus.length) {
                        if (menus[menuNo - 1] == "종료"){
                            // 종료 메뉴일 때 반복문을 나간다.
                            break;
                        }
                        System.out.println(menus[menuNo - 1]);
                    } else {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");

                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
                // keyboardScanner.next(); // nextLine()으로 받으면서 필요없어짐. 이것이 있음으로써 '>' 출력이 안됨. 다른 것도 제대로 안됨.
            }
        }

        // 종료하면 어차피 반복문을 나오니까.
        System.out.println("종료합니다.");

        // 사용을 완료한 자원은 반환해야 다른 프로세스(프로그램)이 사용할 수 있다.
        // 단, JVM을 종료하면 JVM이 사용한 모든 자원은 강제 회수된다.
        // OS가 강제 회수한다.
        keyboardScanner.close();
    }
}