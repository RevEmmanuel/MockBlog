package africa.semicolon.Blog.dtos.requests;

import lombok.*;
//import org.springframework.lang.NonNull;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor // to determine which argument is required, use the @NonNull annotation on that instance variable
//@EqualsAndHashCode
@Data // this annotation contains the getter, setter and toString annotations for all instance variables
public class CreateCommentRequest {
    private int postId;

//    @NonNull
    private String commenterName;

    private String comment;
}
