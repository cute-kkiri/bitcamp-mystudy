package bitcamp.myapp;

public class App00R {
    static java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);

    static String[] mainMenus = new String[] {
            "회원",
            "팀",
            "프로젝트",
            "게시판",
            "도움말",
            "종료"
    };

    static String[] subMenus = new String[] {
            "등록",
            "목록",
            "조회",
            "변경",
            "삭제",
    };

    public static void main(String[] args) {

        printMenu();

        String command;

        while (true) {
            try {
                command = prompt("메인");

                if (command.equals("menu")) {
                    printMenu();

                } else {
                    int menuNo = Integer.parseInt(command);
                    String menuTitle = getMenuTitle(menuNo, mainMenus); // 메뉴 번호 유효성 검사 조건을 명시적인 메서드명으로 변경.

                    if (menuTitle == null) {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                    } else if (menuTitle.equals("종료")) {
                        break;
                    } else if (menuTitle.equals("도움말")) {
                        System.out.println(getMenuTitle(menuNo, mainMenus));
                    } else {
                        printSubMenu(menuNo, mainMenus);
                        processMenu(menuNo, subMenus);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }

        System.out.println("종료합니다.");

        keyboardScanner.close();
    }

    static void printMenu() {
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        String appTitle = "[팀 프로젝트 관리 시스템]";
        String line = "----------------------------------";

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);

        for (int i = 0; i < mainMenus.length; i++) {
            if (mainMenus[i].equals("종료")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), mainMenus[i], resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), mainMenus[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);
    }

    static String prompt(String title) {
        System.out.printf("%s> ", title);
        return keyboardScanner.nextLine(); // replace temp with query 리팩토링 기법 중 하나.
    }

    static boolean isValidateMenu(int menuNo, String[] menus) {
        return menuNo >= 1 && menuNo <= menus.length;
    }

    static String getMenuTitle(int menuNo, String[] menus) {
        return !isValidateMenu(menuNo, menus) ? null : menus[menuNo - 1];
    }

    // sub
    static void printSubMenu(int menuNo, String[] menus) {
        System.out.printf("[%s]\n", getMenuTitle(menuNo, menus));
        for (int i = 0; i < subMenus.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), subMenus[i]);
        }
        System.out.println("9. 이전");
    }

    static void processMenu(int menuNo, String[] menus) {
        String menuTitle = getMenuTitle(menuNo, mainMenus);

        while (true) {
            try {
                String commandSub = prompt("메인/" + menuTitle);

                if (commandSub.equals("menu")) {
                    printSubMenu(menuNo, mainMenus);

                } else if (commandSub.equals("9")) {
                    break;
                } else {
                    int subMenuNo = Integer.parseInt(commandSub);
                    String subMenuTitle = getMenuTitle(subMenuNo, menus);

                    if (subMenuTitle == null) {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                    } else {
                        System.out.println(subMenuTitle);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }
}
