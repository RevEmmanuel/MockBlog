package africa.semicolon.Blog.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatePostRequest {

    private String title;

    private String body;

}
