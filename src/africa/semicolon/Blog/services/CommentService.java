package africa.semicolon.Blog.services;

import africa.semicolon.Blog.data.models.Comment;
import africa.semicolon.Blog.dtos.requests.CreateCommentRequest;
import java.util.List;

public interface CommentService {

    void createComment(CreateCommentRequest commentRequest);

    Comment viewComment(int id);

    List<Comment> viewAll();
}
