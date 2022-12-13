package africa.semicolon.Blog.data.repositories;

import africa.semicolon.Blog.data.models.Comment;
import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);
    Comment findById(int id);
    List<Comment> findAll();
    long count();
    void delete(Comment comment);
    void delete(int id);
}
