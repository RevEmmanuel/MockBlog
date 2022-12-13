package services;

import data.models.Post;
import dtos.requests.CreatePostRequest;

import java.util.List;

public interface PostService {

    void createPost(CreatePostRequest postRequest);

    void updatePost(int id, CreatePostRequest postRequest);

    void deletePost(int id);

    Post viewPost(int id);

    List<Post> viewAll();
}
