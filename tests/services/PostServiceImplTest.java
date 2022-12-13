package services;

import exceptions.PostNotFoundException;
import data.models.Post;
import dtos.requests.CreatePostRequest;
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
        postRequest2.setTitle("Afang");
        postRequest2.setBody("Afang is a delicious soup.");
        postService.updatePost(1, postRequest2);

        assertEquals("Afang", postService.viewPost(1).getTitle());
        assertEquals("Afang is a delicious soup.", postService.viewPost(1).getBody());
        assertEquals(1, postService.viewAll().size());
    }

    @Test
    void deletePostTest() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("Egusi");
        postRequest.setBody("Egusi is my best soup.");
        postService.createPost(postRequest);

        postService.deletePost(1);
        assertEquals(0, postService.viewAll().size());
        assertThrows(PostNotFoundException.class, () -> postService.viewPost(1));
    }

    @Test
    void viewPostTest() {
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("Egusi");
        postRequest.setBody("Egusi is my best soup.");
        postService.createPost(postRequest);

        Post viewedPost = new Post(1, "Egusi", "Egusi is my best soup.");
        assertEquals(viewedPost, postService.viewPost(1));
    }
}