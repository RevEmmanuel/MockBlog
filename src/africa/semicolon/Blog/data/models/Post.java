package africa.semicolon.Blog.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private String title;
    @Id
    private String id;
    private final LocalDateTime creationTime = LocalDateTime.now();
    private String body;
    @DBRef
    private List<Comment> comments = new ArrayList<>();

    public Post(String s, String egusi, String s1) {
        this.id = s;
        this.title = egusi;
        this.body = s1;
    }

    @Override
    public boolean equals(Object obj) {
        Post comparing = (Post) obj;
        return this.id.equals(comparing.getId()) && this.body.equals(comparing.getBody()) && this.title.equals(comparing.getTitle());
    }

    @Override
    public String toString() {
        return "Post { " + '\n' +
                "Post " + id + '\n' +
                "ID= " + id + '\n' +
                "Created on= " + getTimeOfEntry(creationTime) + '\n' +
                "Title= '" + title + '\'' + '\n' +
                "Body= '" + body + '\'' + '\n' +
                "Comments= " + comments + '\n' +
                " }";
    }

    private String getTimeOfEntry(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return time.format(formatter);
    }
}
