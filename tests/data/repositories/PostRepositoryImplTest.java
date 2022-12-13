package data.repositories;

import static org.junit.jupiter.api.Assertions.*;

import exceptions.PostNotFoundException;
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

    @Test
    void saveNewPostUpdatePostCountIsOneTest() {
        Post post = new Post();
        post.setBody("New post body");
        post.setTitle("New post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post updatedPost = new Post();
        updatedPost.setId(1);
        updatedPost.setBody("New post body updated");
        updatedPost.setTitle("New post title updated");
        postRepository.save(updatedPost);

        assertEquals(1L, postRepository.count());
        assertEquals(updatedPost, postRepository.findById(1));

        // check that internal values of post has changed
        assertEquals(updatedPost.getTitle(), post.getTitle());
        assertEquals(updatedPost.getBody(), post.getBody());
    }

    @Test
    void deleteItemByIdCountIsZeroTest() {
        Post post = new Post();
        post.setBody("New post body");
        post.setTitle("New post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
        postRepository.delete(1);
        assertEquals(0L, postRepository.count());
        assertThrows(PostNotFoundException.class, () -> postRepository.findById(1));
    }

    @Test
    void deletePostByPostTest() {
        Post post = new Post();
        post.setBody("New post body");
        post.setTitle("New post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
        postRepository.delete(post);
        assertEquals(0L, postRepository.count());
        assertThrows(PostNotFoundException.class, () -> postRepository.findById(1));
    }

    @Test
    void deleteItemAndCheckThatIdIsNotTheSameTest() {
        Post post = new Post();
        post.setBody("New post body");
        post.setTitle("New post title");
        postRepository.save(post);

        Post post2 = new Post();
        post2.setBody("New post 2");
        post2.setTitle("New post 2");
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setBody("New post 3");
        post3.setTitle("New post 3");
        postRepository.save(post3);
        assertEquals(3, postRepository.count());

        postRepository.delete(1);

        Post post4 = new Post();
        post4.setBody("New post body");
        post4.setTitle("New post title");
        postRepository.save(post4);
        assertNotEquals(3, post4.getId());
        assertEquals(3, postRepository.count());
        assertThrows(PostNotFoundException.class, () -> postRepository.findById(1));
    }

}