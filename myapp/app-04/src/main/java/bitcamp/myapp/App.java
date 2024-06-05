/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.myapp;

public class App {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyboardScanner = new java.util.Scanner(keyboard);

        String appTitle = "[팀 프로젝트 관리 시스템]";
        String line = "----------------------------------------";
        String menu1 = "1. 회원";
        String menu2 = "2. 팀";
        String menu3 = "3. 프로젝트";
        String menu4 = "4. 게시판";
        String menu5 = "5. 도움말";
        String menu6 = "6. 종료";

        System.out.println(line);
        System.out.println(appTitle);
        System.out.println(menu1);
        System.out.println(menu2);
        System.out.println(menu3);
        System.out.println(menu4);
        System.out.println(menu5);
        System.out.println(menu6);
        System.out.println(line);

        int menuNo;

        do {
            System.out.print("> ");
            menuNo = keyboardScanner.nextInt();

            switch(menuNo) {
                case 1:
                    System.out.println("회원");
                    break;
                case 2:
                    System.out.println("팀");
                    break;
                case 3:
                    System.out.println("프로젝트");
                    break;
                case 4:
                    System.out.println("게시판");
                    break;
                case 5:
                    System.out.println("도움말");
                    break;
                case 6:
                    System.out.println("종료합니다.");
                    break;
                default:
                    System.out.println("메뉴 번호가 옳지 않습니다.");
                    break;
            }
        } while (menuNo != 6);

        keyboardScanner.close();
    }
}
