package bitcamp.myapp;

public class App00 {
    static java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);

    static String[] menus = new String[] {
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
            "이전",
    };

    public static void main(String[] args) {

        printMenu();

        String command;

        while (true) {
            try {
                command = prompt();

                if (command.equals("menu")) {
                    printMenu();

                } else {
                    int menuNo = Integer.parseInt(command);
                    String menuTitle = getMenuTitle(menuNo); // 메뉴 번호 유효성 검사 조건을 명시적인 메서드명으로 변경.

                    if (menuTitle == null) {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                    } else if (menuTitle.equals("종료")) {
                        break;
                    } else if (menuTitle.equals("도움말")) {
                        System.out.println(getMenuTitle(menuNo));
                    } else {
                        printSubMenu(menuNo);

                        while (true) {
                            try {
                                String commandSub = subPrompt(menuNo);

                                if (commandSub.equals("menu")) {
                                    printSubMenu(menuNo);

                                } else  {
                                    int subMenuNo = Integer.parseInt(commandSub);
                                    String subMenuTitle = getSubMenuTitle(subMenuNo);

                                    if (subMenuTitle == null) {
                                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                                    } else if (subMenuTitle.equals(("이전"))) {
                                            break;
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

        for (int i = 0; i < menus.length; i++) {
            if (menus[i].equals("종료")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), menus[i], resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), menus[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);
    }

    static String prompt() {
        System.out.print("메인> ");
        return keyboardScanner.nextLine(); // replace temp with query 리팩토링 기법 중 하나.
    }

    static boolean isValidateMenu(int menuNo) {
        return menuNo >= 1 && menuNo <= menus.length;
    }

    static String getMenuTitle(int menuNo) {
        return !isValidateMenu(menuNo) ? null : menus[menuNo - 1];
    }

    // sub
    static void printSubMenu(int menuNo) {
        System.out.printf("[%s]\n", getMenuTitle(menuNo));
        for (int i = 0; i < subMenus.length; i++) {
            if (subMenus[i].equals("이전")) {
                System.out.printf("9. %s\n", subMenus[i]);
            } else {
                System.out.printf("%d. %s\n", (i + 1), subMenus[i]);
            }
        }
    }

    static String subPrompt(int menuNo) {
        System.out.printf("메인/%s> ", getMenuTitle(menuNo));
        return keyboardScanner.nextLine();
    }

    static boolean isValidateSubMenu(int subMenuNo) {
        return subMenuNo >= 1 && subMenuNo <= subMenus.length;
    }

    static String getSubMenuTitle(int subMenuNo) {
        return !isValidateSubMenu(subMenuNo) ? null : subMenus[subMenuNo - 1];
    }
}
