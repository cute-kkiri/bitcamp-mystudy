package bitcamp.myapp;

public class TeamCommand {
    static Team[] teams = new Team[UserCommand.MAX_SIZE];
    static int teamLength = 0;
    static int teamUserLength = 0;

    static void executeTeamCommand(String command) {
        System.out.printf("[%s]\n", command);
        for (int i = 0; i < UserCommand.userLength; i++) {
            System.out.println(UserCommand.users[i].name);
        }


        switch (command) {
            case "등록":
                Team team = new Team();
                team.teamName = Prompt.input("팀명?");
                teams[teamLength++] = team;
                while (true) {
                    int userNo = Integer.parseInt(Prompt.input("추가할 팀원 번호?(종료: 0)"));

                    if (userNo == 0) {
                        System.out.println("등록 했습니다.");
                        break;
                    } else if (userNo > UserCommand.userLength) {
                        System.out.println("없는 팀원입니다.");
                    } else {
                        System.out.println(team);
                    }
                }
                break;
            case "목록":
                System.out.println(command);
                break;
            case "조회":
                System.out.println(command);
                break;
            case "변경":
                System.out.println(command);
                break;
            case "삭제":
                System.out.println(command);
                break;
        }
    }
}
