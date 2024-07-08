package bitcamp.myapp.command;

import bitcamp.myapp.util.Prompt;

public abstract class AbstractCommand implements Command {
    protected String menuTitle;

    public AbstractCommand(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    @Override
    public void execute() {
        printMenus();

        while (true) {
            String command = Prompt.input(String.format("메인/%s>", menuTitle));
            if (command.equals("menu")) {
                printMenus();
                continue;
            } else if (command.equals("9")) { // 이전 메뉴 선택
                return;
            }

            try {
                int menuNo = Integer.parseInt(command);
                String menuName = getMenuTitle(menuNo);
                if (menuName == null) {
                    System.out.println("유효한 메뉴 번호가 아닙니다.");
                    continue;
                }

                processMenu(menuName);
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }

    private void printMenus() {
        String[] menus = getMenus(); // 템플릿 메서드.
        System.out.printf("[%s]\n", menuTitle);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), menus[i]);
        }
        System.out.println("9. 이전");
    }

    private String getMenuTitle(int menuNo) {
        String[] menus = getMenus();
        return isValidateMenu(menuNo) ? menus[menuNo - 1] : null;
    }

    private boolean isValidateMenu(int menuNo) {
        String[] menus = getMenus();
        return menuNo >= 1 && menuNo <= menus.length;
    }

    // 구체적인 동작은 서브 클래스에서 정의한다.
    protected abstract String[] getMenus(); // 템플릿 메서드.

    protected abstract void processMenu(String menuName);
}
