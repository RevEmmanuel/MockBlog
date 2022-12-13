package data.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private String title;
    private int id;
    private final LocalDateTime creationTime = LocalDateTime.now();
    private String body;
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String body) {
        this(0, title, body);
    }
    public Post() {}

    public Post(int id, String title, String body) {
        this.title = title;
        this.id = id;
        this.body = body;
    }

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

    @Override
    public boolean equals(Object obj) {
        Post comparing = (Post) obj;
        return this.id == comparing.getId() && this.body.equals(comparing.getBody()) && this.title.equals(comparing.getTitle());
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post { " +
                "title='" + title + '\'' +
                ", id=" + id +
                ", creationTime=" + creationTime +
                ", body='" + body + '\'' +
                ", comments=" + comments +
                " }";
    }
}
