package africa.semicolon.Blog.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Comment {

    private String commenterName;
    @Id
    private String id;
    private String comment;

//    @Override
//    public boolean equals(Object obj) {
//        Comment comparing = (Comment) obj;
//        return this.id.equals(comparing.getId()) && this.commenterName.equals(comparing.getCommenterName()) && this.comment.equals(comparing.getComment());
//    }
}
