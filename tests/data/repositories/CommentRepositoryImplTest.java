package data.repositories;

import africa.semicolon.Blog.data.repositories.CommentRepository;
import africa.semicolon.Blog.exceptions.CommentNotFoundException;
import africa.semicolon.Blog.data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void saveTest() {
        Comment comment = new Comment();
        comment.setCommenterName("Omenma");
        comment.setComment("This class self nawa o.");
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
    }

    @Test
    void findByIdTest() {
        Comment comment = new Comment();
        comment.setCommenterName("Omenma");
        comment.setComment("This class self nawa o.");
        commentRepository.save(comment);
        assertEquals(comment, commentRepository.findById("1"));
    }

    @Test
    void count() {
        Comment comment = new Comment();
        comment.setCommenterName("Omenma");
        comment.setComment("This class self nawa o.");
        commentRepository.save(comment);

        Comment comment2 = new Comment();
        comment.setCommenterName("Chibuzor");
        comment.setComment("I love violence");
        commentRepository.save(comment2);

        Comment comment3 = new Comment();
        comment3.setCommenterName("Henry");
        comment3.setComment("Leave space for Jesus.");
        commentRepository.save(comment3);
        assertEquals(3, commentRepository.count());
    }

    @Test
    void deleteByIdTest() {
        Comment comment = new Comment();
        comment.setCommenterName("Omenma");
        comment.setComment("This class self nawa o.");
        commentRepository.save(comment);

        commentRepository.delete(comment);
        assertThrows(CommentNotFoundException.class, () -> commentRepository.findById("1"));
    }

    @Test
    void testDeleteByComment() {
        Comment comment = new Comment();
        comment.setCommenterName("Omenma");
        comment.setComment("This class self nawa o.");
        commentRepository.save(comment);

        commentRepository.delete(comment);
        assertThrows(CommentNotFoundException.class, () -> commentRepository.findById("1"));
    }
}