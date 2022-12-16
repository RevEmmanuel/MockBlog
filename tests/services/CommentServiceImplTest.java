package services;

import africa.semicolon.Blog.dtos.requests.CreateCommentRequest;
import africa.semicolon.Blog.dtos.requests.CreatePostRequest;
import africa.semicolon.Blog.services.CommentService;
import africa.semicolon.Blog.services.CommentServiceImpl;
import africa.semicolon.Blog.services.PostService;
import africa.semicolon.Blog.services.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceImplTest {

    private CommentService commentService;
    private PostService postService;

    @BeforeEach
    void setUp() {
        commentService = new CommentServiceImpl();
        postService = new PostServiceImpl();
    }

    @Test
    void createCommentTest() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("Egusi");
        postRequest.setBody("Egusi is my best soup.");
        postService.createPost(postRequest);

        CreateCommentRequest commentRequest = new CreateCommentRequest();
        commentRequest.setCommenterName("Amirah");
        commentRequest.setComment("I love the post");
        commentRequest.setPostId("1");
        commentService.createComment(commentRequest);

        assertEquals(1, commentService.viewAll().size());
    }
}