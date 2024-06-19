package bitcamp.myapp.vo;

import java.time.LocalDate;

public class Board {
    private String title;
    private String content;
    private LocalDate date;
    private int viewCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date = LocalDate.now();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
