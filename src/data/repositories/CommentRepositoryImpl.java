package data.repositories;

import exceptions.CommentNotFoundException;
import data.models.Comment;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {

    List<Comment> comments = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == 0) saveComment(comment);
        else updateComment(comment);
        return comment;
    }

    private void updateComment(Comment comment) {
        Comment foundComment = findById(comment.getId());
        foundComment.setCommenterName(comment.getCommenterName());
        foundComment.setComment(comment.getComment());
    }

    private void saveComment(Comment comment) {
        comment.setId(idCounter++);
        comments.add(comment);
    }

    @Override
    public Comment findById(int id) {
        for (Comment comment : comments) if (comment.getId() == id) return comment;
        throw new CommentNotFoundException("No such comment");
    }

    @Override
    public List<Comment> findAll() {
        return comments;
    }

    @Override
    public long count() {
        return comments.size();
    }

    @Override
    public void delete(Comment comment) {
        comments.remove(getIndex(comment));
    }

    @Override
    public void delete(int id) {
        comments.remove(getIndex(id));
    }

    private int getIndex(Comment comment) {
        int index = 0;
        for (Comment comment1 : comments) {
            if (comment1.getId() == comment.getId()) return index;
            index++;
        }
        throw new CommentNotFoundException("Comment not found.");
    }

    private int getIndex(int id) {
        int index = 0;
        for (Comment comment : comments) {
            if (comment.getId() == id) return index;
            index++;
        }
        throw new CommentNotFoundException("Comment not found.");
    }
}
