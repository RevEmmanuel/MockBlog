package africa.semicolon.Blog.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Comment {

    private String commenterName;
    private int id;
    private String comment;

    public Comment(int id, String commenterName, String comment) {
        this.commenterName = commenterName;
        this.id = id;
        this.comment = comment;
    }

//    @Override
//    public boolean equals(Object obj) {
//        Comment comparing = (Comment) obj;
//        return this.id == comparing.getId() && this.commenterName.equals(comparing.getCommenterName()) && this.comment.equals(comparing.getComment());
//    }
}
