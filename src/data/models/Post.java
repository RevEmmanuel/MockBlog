package data.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private String title;
    private int id;
    private final LocalDateTime creationTime =LocalDateTime.now();
    private String body;
    private List<Comment> comments = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
