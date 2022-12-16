package africa.semicolon.Blog.services;

import africa.semicolon.Blog.data.models.Comment;
import africa.semicolon.Blog.data.repositories.CommentRepository;
import africa.semicolon.Blog.dtos.requests.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostService postService;

    @Override
    public void createComment(CreateCommentRequest commentRequest) {
        Comment newComment = new Comment();
        newComment.setCommenterName(commentRequest.getCommenterName());
        newComment.setComment(commentRequest.getComment());
        Comment savedComment = commentRepository.save(newComment);
        postService.addComment(commentRequest.getPostId(), savedComment);
    }

    @Override
    public Comment viewComment(String id) {
//        return commentRepository.findById(id);
        return null;
    }

    @Override
    public List<Comment> viewAll() {
        return commentRepository.findAll();
    }

}
