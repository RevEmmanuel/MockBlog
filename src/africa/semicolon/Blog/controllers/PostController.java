package africa.semicolon.Blog.controllers;

import africa.semicolon.Blog.data.models.Post;
import africa.semicolon.Blog.dtos.requests.CreatePostRequest;
import africa.semicolon.Blog.services.PostService;
import africa.semicolon.Blog.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest postRequest) {
        postService.createPost(postRequest);
        return "Successful!";
    }

    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable String postId) {
        return postService.viewPost(postId);
    }
}
