package data.repositories;

import data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    List<Post> postDb = new ArrayList<>();
    int idCounter = 1;

    @Override
    public Post save(Post post) {
        if (post.getId() == 0) post.setId(idCounter++);
        postDb.add(post);
        return post;
    }

    @Override
    public Post findById(int id) {
        for (Post post : postDb) if (post.getId() == id) return post;
        return null;
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

    }

    private boolean postExistsAlready(Post searchPost) {
        for (Post post : postDb) {
            if (post.getId() == searchPost.getId()) return true;
        }
        return false;
    }
}
