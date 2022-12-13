package controllers;

import data.models.Post;
import dtos.requests.CreatePostRequest;
import services.PostService;
import services.PostServiceImpl;

public class PostController {
    private final PostService postService = new PostServiceImpl();

    public String createPost(CreatePostRequest postRequest) {
        postService.createPost(postRequest);
        return "Successful!";
    }

    public Post viewPost(int postId) {
        return postService.viewPost(postId);
    }
}
