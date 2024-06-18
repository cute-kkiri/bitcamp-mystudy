package bitcamp.myapp.vo;

public class Project {
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private User[] members = new User[10];
    private int memberSize;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean containsMember(User user) {
        for (int i = 0; i < this.memberSize; i++) {
            User member = this.members[i];
            if (member.getName().equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

    public void addMember(User user) {
        this.members[this.memberSize++] = user;
    }

    public int countMembers() {
        return this.memberSize;
    }

    public User getMember(int index) {
        return this.members[index];
    }

    public void deleteMember(int index) {
        for (int i = index + 1; i < this.memberSize; i++) {
            this.members[i - 1] = this.members[i];
        }
        this.members[--this.memberSize] = null;
    }
}
