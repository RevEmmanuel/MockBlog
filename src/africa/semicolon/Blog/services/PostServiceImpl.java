package africa.semicolon.Blog.services;

import africa.semicolon.Blog.data.models.Comment;
import africa.semicolon.Blog.data.models.Post;
import africa.semicolon.Blog.data.repositories.PostRepository;
import africa.semicolon.Blog.dtos.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public void createPost(CreatePostRequest postRequest) {
        Post newPost = new Post();
        newPost.setBody(postRequest.getBody());
        newPost.setTitle(postRequest.getTitle());
        postRepository.save(newPost);
    }

    @Override
    public void updatePost(String id, CreatePostRequest postRequest) {
        Post foundPost = postRepository.findPostById(id);
        foundPost.setTitle(postRequest.getTitle());
        foundPost.setBody(postRequest.getBody());
    }

    @Override
    public void deletePost(String id) {
        postRepository.delete(postRepository.findPostById(id));
    }

    @Override
    public Post viewPost(String id) {
        return postRepository.findPostById(id);
    }

    @Override
    public List<Post> viewAll() {
        return postRepository.findAll();
    }

    @Override
    public void addComment(String postId, Comment comment) {
        Post foundPost = viewPost(postId);
        foundPost.getComments().add(comment);
        postRepository.save(foundPost);
    }

}
