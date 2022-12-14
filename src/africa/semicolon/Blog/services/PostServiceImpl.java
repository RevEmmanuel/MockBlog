package africa.semicolon.Blog.services;

import africa.semicolon.Blog.data.models.Comment;
import africa.semicolon.Blog.data.models.Post;
import africa.semicolon.Blog.data.repositories.PostRepository;
import africa.semicolon.Blog.data.repositories.PostRepositoryImpl;
import africa.semicolon.Blog.dtos.requests.CreatePostRequest;

import java.util.List;

public class PostServiceImpl implements PostService {
    PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public void createPost(CreatePostRequest postRequest) {
        Post newPost = new Post();
        newPost.setBody(postRequest.getBody());
        newPost.setTitle(postRequest.getTitle());
        postRepository.save(newPost);
    }

    @Override
    public void updatePost(int id, CreatePostRequest postRequest) {
        Post foundPost = postRepository.findById(id);
        foundPost.setTitle(postRequest.getTitle());
        foundPost.setBody(postRequest.getBody());
    }

    @Override
    public void deletePost(int id) {
        postRepository.delete(id);
    }

    @Override
    public Post viewPost(int id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> viewAll() {
        return postRepository.findAll();
    }

    @Override
    public void addComment(int postId, Comment comment) {
        Post foundPost = viewPost(postId);
        foundPost.getComments().add(comment);
        postRepository.save(foundPost);
    }

}
