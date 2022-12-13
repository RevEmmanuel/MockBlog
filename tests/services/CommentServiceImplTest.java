package services;

import data.models.Comment;
import dtos.requests.CreateCommentRequest;
import exceptions.CommentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceImplTest {

    private CommentService commentService;

    @BeforeEach
    void setUp() {
        commentService = new CommentServiceImpl();
    }

    @Test
    void createCommentTest() {
        CreateCommentRequest commentRequest = new CreateCommentRequest();
        commentRequest.setCommenterName("Amirah");
        commentRequest.setComment("I be big girl.");
        commentService.createComment(commentRequest);
        assertEquals(1, commentService.viewAll().size());
    }

    @Test
    void updateCommentTest() {
        CreateCommentRequest commentRequest = new CreateCommentRequest();
        commentRequest.setCommenterName("Amirah");
        commentRequest.setComment("I be big girl.");
        commentService.createComment(commentRequest);

        CreateCommentRequest commentRequest2 = new CreateCommentRequest();
        commentRequest2.setCommenterName("Amirah");
        commentRequest2.setComment("I be small girl.");
        commentService.updateComment(1, commentRequest2);
        assertEquals(1, commentService.viewAll().size());
    }

    @Test
    void deleteCommentTest() {
        CreateCommentRequest commentRequest = new CreateCommentRequest();
        commentRequest.setCommenterName("Amirah");
        commentRequest.setComment("I be big girl.");
        commentService.createComment(commentRequest);
        assertEquals(1, commentService.viewAll().size());

        commentService.deleteComment(1);
        assertEquals(0, commentService.viewAll().size());
        assertThrows(CommentNotFoundException.class, () -> commentService.viewComment(1));
    }

    @Test
    void viewCommentTest() {
        CreateCommentRequest commentRequest = new CreateCommentRequest();
        commentRequest.setCommenterName("Amirah");
        commentRequest.setComment("I be big girl.");
        commentService.createComment(commentRequest);
        assertEquals(1, commentService.viewAll().size());

        Comment comment = new Comment(1, "Amirah", "I be big girl.");
        assertEquals(comment, commentService.viewComment(1));
    }

}