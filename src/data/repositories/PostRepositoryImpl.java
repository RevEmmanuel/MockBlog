package data.repositories;

import Exceptions.PostNotFoundException;
import data.models.Post;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    List<Post> postDb = new ArrayList<>();
    int idCounter = 1;

    @Override
    public Post save(Post post) {
        if (post.getId() == 0) savePost(post);
        else updatePostDetails(post);
        return post;
    }

    private void updatePostDetails(Post post) {
        //x find the original
        Post foundPost = findById(post.getId());
        // set the new details
        foundPost.setTitle(post.getTitle());
        foundPost.setBody(post.getBody());
        foundPost.setComments(post.getComments());
    }

    private void savePost(Post post) {
        post.setId(idCounter++);
        postDb.add(post);
    }

    @Override
    public Post findById(int id) {
        for (Post post : postDb) if (post.getId() == id) return post;
        throw new PostNotFoundException("Post does not exist.");
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public long count() {
        return postDb.size();
    }

    @Override
    public void delete(Post post) {

    }

    @Override
    public void delete(int id) {
        postDb.remove(findById(id));
    }
}
