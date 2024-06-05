/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.myapp;

public class App {
    public static void main(String[] args) {
        // 변수를 작성할 때 설명하는 변수명(변수의 역할과 맞는 이름)으로 작성하는 것이 리팩토링 기법 중 하나.
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m"; // 종료 이스케이프문자는 두 번적을 필요없다. 여러개를 했을 때.

        String appTitle = "[팀 프로젝트 관리 시스템]"; // 볼드체
        String line = "----------------------------------------"; // 볼드체
        String menu1 = "1. 회원";
        String menu2 = "2. 팀";
        String menu3 = "3. 프로젝트";
        String menu4 = "4. 게시판";
        String menu5 = "5. 도움말";
        String menu6 = "6. 종료"; // 빨강색 + 볼드체

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);
        System.out.println(menu1);
        System.out.println(menu2);
        System.out.println(menu3);
        System.out.println(menu4);
        System.out.println(menu5);
        System.out.println(boldAnsi + redAnsi + menu6 + resetAnsi);
        System.out.println(boldAnsi + line + resetAnsi);
    }
}
