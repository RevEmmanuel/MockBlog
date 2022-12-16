package services;

import africa.semicolon.Blog.data.models.Comment;
import africa.semicolon.Blog.dtos.requests.CreateCommentRequest;
import africa.semicolon.Blog.exceptions.PostNotFoundException;
import africa.semicolon.Blog.data.models.Post;
import africa.semicolon.Blog.dtos.requests.CreatePostRequest;
import africa.semicolon.Blog.services.PostService;
import africa.semicolon.Blog.services.PostServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {

    private PostService postService;

    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
    }

    @Test
    void createPostTest() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("New post");
        postRequest.setBody("Egusi is my best soup.");
        postService.createPost(postRequest);
        assertEquals(1L, postService.viewAll().size());
    }

    @Test
    void updatePostTest() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("Egusi");
        postRequest.setBody("Egusi is my best soup.");
        postService.createPost(postRequest);

        CreatePostRequest postRequest2 = new CreatePostRequest();
        postRequest2.setTitle("A fang");
        postRequest2.setBody("A fang is a delicious soup.");
        postService.updatePost("1", postRequest2);

        assertEquals("A fang", postService.viewPost("1").getTitle());
        assertEquals("A fang is a delicious soup.", postService.viewPost("1").getBody());
        assertEquals(1, postService.viewAll().size());
    }

    @Test
    void deletePostTest() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("Egusi");
        postRequest.setBody("Egusi is my best soup.");
        postService.createPost(postRequest);

        postService.deletePost("1");
        assertEquals(0, postService.viewAll().size());
        assertThrows(PostNotFoundException.class, () -> postService.viewPost("1"));
    }

    @Test
    void viewPostTest() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("Egusi");
        postRequest.setBody("Egusi is my best soup.");
        postService.createPost(postRequest);

        Post viewedPost = new Post("1", "Egusi", "Egusi is my best soup.");
        assertEquals(viewedPost, postService.viewPost("1"));
    }

    @Test
    void createAndAddCommentTest() {
        // given I have  a saved post
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("Egusi");
        postRequest.setBody("Egusi is my best soup.");
        postService.createPost(postRequest);

        // and I create a comment and save the comment to the post
        Comment comment = new Comment();
        comment.setCommenterName("Amirah");
        comment.setComment("I like jeshe jeshe");
        postService.addComment("1", comment);

        // check that post's comment is now 1
        Post savedPost = postService.viewPost("1");
        assertEquals(1, savedPost.getComments().size());
        assertEquals("I like jeshe jeshe", savedPost.getComments().get(0).getComment());
        assertEquals("Amirah", savedPost.getComments().get(0).getCommenterName());
    }
}