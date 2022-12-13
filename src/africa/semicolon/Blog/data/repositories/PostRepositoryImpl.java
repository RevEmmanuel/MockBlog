package africa.semicolon.Blog.data.repositories;

import africa.semicolon.Blog.exceptions.PostNotFoundException;
import africa.semicolon.Blog.data.models.Post;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    private final List<Post> postDb = new ArrayList<>();
    private int idCounter = 1;

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
        return postDb;
    }

    @Override
    public long count() {
        return postDb.size();
    }

    @Override
    public void delete(Post post) {
        postDb.remove(getIndex(post));
    }

    @Override
    public void delete(int id) {
        postDb.remove(getIndex(id));
    }

    private int getIndex(int id) {
        int index = 0;
        for (Post post : postDb) {
            if (post.getId() == id) return index;
            index++;
        }
        throw new PostNotFoundException("Post does not exist.");
    }

    private int getIndex(Post post) {
        int index = 0;
        for (Post foundPost : postDb) {
            if (post.getId() == foundPost.getId()) return index;
            index++;
        }
        throw new PostNotFoundException("Post does not exist.");
    }
}
