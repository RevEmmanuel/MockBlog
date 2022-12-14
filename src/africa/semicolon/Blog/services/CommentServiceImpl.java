package africa.semicolon.Blog.services;

import africa.semicolon.Blog.data.models.Comment;
import africa.semicolon.Blog.data.repositories.CommentRepository;
import africa.semicolon.Blog.data.repositories.CommentRepositoryImpl;
import africa.semicolon.Blog.dtos.requests.CreateCommentRequest;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    CommentRepository commentRepository = new CommentRepositoryImpl();
    PostService postService;

    public CommentServiceImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public void createComment(CreateCommentRequest commentRequest) {
        Comment newComment = new Comment();
        newComment.setCommenterName(commentRequest.getCommenterName());
        newComment.setComment(commentRequest.getComment());
        Comment savedComment = commentRepository.save(newComment);
        postService.addComment(commentRequest.getPostId(), savedComment);
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
