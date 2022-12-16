package africa.semicolon.Blog.services;

import africa.semicolon.Blog.data.models.Comment;
import africa.semicolon.Blog.data.models.Post;
import africa.semicolon.Blog.dtos.requests.CreateCommentRequest;
import africa.semicolon.Blog.dtos.requests.CreatePostRequest;

import java.util.List;

public interface PostService {

    void createPost(CreatePostRequest postRequest);

    void updatePost(String id, CreatePostRequest postRequest);

    void deletePost(String id);

    Post viewPost(String id);

    List<Post> viewAll();

    void addComment(String postId, Comment comment);

}
