package data.repositories;

import static org.junit.jupiter.api.Assertions.*;

import data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostRepositoryImplTest {

    PostRepository postRepository;
    @BeforeEach
    void setUp() {
        postRepository = new PostRepositoryImpl();
    }

    @Test
    void saveNewPostCountShouldBeOneTest() {
        Post post = new Post();
        post.setBody("New post body");
        post.setTitle("New post title");
        postRepository.save(post);

        assertEquals(1L, postRepository.count());
    }

    @Test
    void canSaveMultiplePosts() {
        Post post = new Post();
        post.setBody("New post body");
        post.setTitle("New post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post post2 = new Post();
        post2.setBody("New post body2");
        post2.setTitle("New post title2");
        postRepository.save(post2);
        assertEquals(2L, postRepository.count());
    }

    @Test
    void saveNewPostFindByIdShouldReturnSavedPostTest() {
        Post post = new Post();
        post.setBody("New post body");
        post.setTitle("New post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post savedPost = postRepository.findById(1);
        assertEquals(post, savedPost);
    }


}