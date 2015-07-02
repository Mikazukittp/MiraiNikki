package app.android.mikazuki.ttp.mirainikki.domain.entity;

/**
 * Created by haijimakazuki on 15/07/01.
 */
public class Plan {

    private int id;
    private String content;
    private String date;

    public Plan() {
    }

    public Plan(int id, String content, String date) {
        this.id = id;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
