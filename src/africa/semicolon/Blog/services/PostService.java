package africa.semicolon.Blog.services;

import africa.semicolon.Blog.data.models.Post;
import africa.semicolon.Blog.dtos.requests.CreatePostRequest;

import java.util.List;

public interface PostService {

    void createPost(CreatePostRequest postRequest);

    void updatePost(int id, CreatePostRequest postRequest);

    void deletePost(int id);

    Post viewPost(int id);

    List<Post> viewAll();
}
