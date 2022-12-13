package services;

import data.models.Comment;
import data.repositories.CommentRepository;
import data.repositories.CommentRepositoryImpl;
import dtos.requests.CreateCommentRequest;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    CommentRepository commentRepository = new CommentRepositoryImpl();

    @Override
    public void createComment(CreateCommentRequest commentRequest) {
        Comment newComment = new Comment();
        newComment.setCommenterName(commentRequest.getCommenterName());
        newComment.setComment(commentRequest.getComment());
        commentRepository.save(newComment);
    }

    @Override
    public void updateComment(int id, CreateCommentRequest commentRequest) {
        Comment foundComment = commentRepository.findById(id);
        foundComment.setComment(commentRequest.getComment());
        foundComment.setCommenterName(commentRequest.getCommenterName());
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.delete(1);
    }

    @Override
    public Comment viewComment(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> viewAll() {
        return commentRepository.findAll();
    }

}
